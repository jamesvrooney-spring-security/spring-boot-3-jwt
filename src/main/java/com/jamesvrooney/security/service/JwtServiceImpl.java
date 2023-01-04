package com.jamesvrooney.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.key}")
    private String key;

    @Override
    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {

        final JwtParser build = Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build();

        final Claims claims = build.parseClaimsJws(token).getBody();

        return claims;
    }

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(key);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
