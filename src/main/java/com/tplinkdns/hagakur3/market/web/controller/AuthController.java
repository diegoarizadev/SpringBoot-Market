package com.tplinkdns.hagakur3.market.web.controller;


import com.tplinkdns.hagakur3.market.domain.dto.AuthenticationRequest;
import com.tplinkdns.hagakur3.market.domain.dto.AuthenticationResponse;
import com.tplinkdns.hagakur3.market.domain.service.UserDetailsServicesCustom;
import com.tplinkdns.hagakur3.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Se garantiza que esta clase va ser un controlador de una API Rest
@RequestMapping("/auth") //Path para consumir el servicio.
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServicesCustom UserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

                UserDetails userDetails = UserDetailsService.loadUserByUsername(request.getUsername());

                String jwt = jwtUtil.generateToken(userDetails);

                return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
            } catch (BadCredentialsException e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
    }

}
