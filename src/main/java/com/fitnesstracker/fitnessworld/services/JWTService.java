package com.fitnesstracker.fitnessworld.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.fitnesstracker.fitnessworld.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Service
public class JWTService {
    private static final String SECRET_KEY = "my-32-byte-secret-key-for-my-website-is-jerry";
    private static final long EXPIRATION_TIME = 86400000;

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    @SuppressWarnings("deprecation")
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("firstName", user.getFirstName());
        claims.put("calorieGoal", user.getCalorieGoal());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
