package com.forts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Health check endpoint for monitoring and deployment platforms
 */
@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    /**
     * Basic health check endpoint
     * Used by Railway, Render, and other platforms to verify the app is running
     * 
     * @return Health status with database connectivity
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> healthStatus = new HashMap<>();
        
        try {
            // Check database connectivity
            try (Connection connection = dataSource.getConnection()) {
                boolean isValid = connection.isValid(5);
                healthStatus.put("status", isValid ? "UP" : "DOWN");
                healthStatus.put("database", isValid ? "Connected" : "Disconnected");
            }
        } catch (Exception e) {
            healthStatus.put("status", "DOWN");
            healthStatus.put("database", "Error: " + e.getMessage());
            return ResponseEntity.status(503).body(healthStatus);
        }
        
        healthStatus.put("application", "Forts of Swarajya");
        healthStatus.put("version", "1.0.0");
        
        return ResponseEntity.ok(healthStatus);
    }

    /**
     * Simple ping endpoint
     */
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
