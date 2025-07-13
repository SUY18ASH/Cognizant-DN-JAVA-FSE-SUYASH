package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).build();
        }
        String[] creds = new String(Base64.getDecoder()
                .decode(authHeader.substring(6)),
                StandardCharsets.UTF_8)
                .split(":", 2);
        if (creds.length < 2 || !"user".equals(creds[0]) || !"pwd".equals(creds[1])) {
            return ResponseEntity.status(401).build();
        }
        String token = jwtUtil.generateToken(creds[0]);
        return ResponseEntity.ok(Map.of("token", token));
    }
}