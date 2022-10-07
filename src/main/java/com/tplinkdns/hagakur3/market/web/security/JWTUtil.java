package com.tplinkdns.hagakur3.market.web.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@Component
public class JWTUtil {

    private static final String KEY = "n0rf3n";
    public String generateToken(UserDetails userDetails){

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 ))
                .signWith(SignatureAlgorithm.HS256, secretKeyFor(SignatureAlgorithm.HS256))
                .compact();
    }


}
