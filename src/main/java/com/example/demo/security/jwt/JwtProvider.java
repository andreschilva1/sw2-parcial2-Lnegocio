package com.example.demo.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtProvider {
    @Autowired
    private Environment env;

    private String secret = env.getProperty("jwt.secret");
    private Integer expiration = Integer.parseInt(env.getProperty("jwt.expiration"));

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities())
                .issuedAt(new Date())
                .expiration(new Date(Calendar.getInstance().getTimeInMillis() + expiration * 1000))
                .signWith(getKey(secret))
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
        .verifyWith(getKey(secret))
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    private SecretKey getKey(String secret) {
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }

}
