package com.tplinkdns.hagakur3.market.web.security.filter;

import com.tplinkdns.hagakur3.market.domain.service.UserDetailsServicesCustom;
import com.tplinkdns.hagakur3.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//filtro para ejecutar en cualquier petición
@Component //Para poder inyectar.
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsServicesCustom userDetailsServiceCustom;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Identificar que en el Header contenga el token y este este valido.
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) { //Validar el header y el Bearer

            String jwt = authorizationHeader.substring(7); // se descuenta la palabra Bearer y se optiene el token.
            String username = jwtUtil.extractUsername(jwt); //Validar el usuario.

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { //Se verifica el usuario y que este no haya ingresado previamente y no este logeado
                UserDetails userDetails = userDetailsServiceCustom.loadUserByUsername(username); //Usuario validado.

                if (jwtUtil.validateToken(jwt, userDetails)) { //Validar el token

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //Detalles de la conexión que esta recibiendo

                    SecurityContextHolder.getContext().setAuthentication(authToken); //Se asigna la autenticación.
                }
            }
        }

        filterChain.doFilter(request, response); //Se evalua el filtro.
    }
}
