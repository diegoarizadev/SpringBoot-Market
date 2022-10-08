package com.tplinkdns.hagakur3.market.web.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@Component
public class JWTUtil {

    private static final String KEY = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    private Key key = secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(UserDetails userDetails){

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(KEY),
                SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 ))
                .signWith(hmacKey)
                .compact();
    }


    //Valida el Token de las peticiones.
    public boolean validateToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject(); //Usuario de la petici´´n
    }

    //Validación de la expiración del token
    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {//Valida la petición y retorna cada uno de los valores del body

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(KEY),
                SignatureAlgorithm.HS256.getJcaName());
        return  Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token).getBody();



    }

}
