package com.SecurityDemo.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello from a public endpoint",
                "access", "anyone can call this without logging in"
        );
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "app", "Spring Security practice",
                "hint", "Try /api/private/hello with HTTP Basic auth"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
