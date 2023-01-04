package com.jamesvrooney.security.service;

public interface JwtService {
    String extractUsername(String token);
}
