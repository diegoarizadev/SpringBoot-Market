package com.tplinkdns.hagakur3.market.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {

    private static final String KEY = "N0rf3n";

    public String generateToken(){

        return Jwts.builder()
                .setSubject("Ariza")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 ))
                .signWith(SignatureAlgorithm.HS256,KEY)
                .compact();
    }


}
