package com.SecurityDemo.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gateways")
public class GatewayController {

    @GetMapping
    public Map<String, Object> viewGateways() {
        return Map.of(
                "permission", "GATEWAY_VIEW",
                "gateways", List.of(
                        Map.of("id", 1, "name", "Gateway A", "ip", "10.0.0.11", "status", "ONLINE"),
                        Map.of("id", 2, "name", "Gateway B", "ip", "10.0.0.12", "status", "OFFLINE")
                )
        );
    }

    @PostMapping
    public Map<String, Object> addGateway() {
        return Map.of(
                "permission", "GATEWAY_ADD",
                "message", "Gateway created",
                "gateway", Map.of("id", 3, "name", "Gateway C", "ip", "10.0.0.13", "status", "ONLINE")
        );
    }

    @PutMapping("/{id}")
    public Map<String, Object> editGateway(@PathVariable int id) {
        return Map.of(
                "permission", "GATEWAY_EDIT",
                "message", "Gateway updated",
                "gateway", Map.of("id", id, "name", "Updated Gateway", "ip", "10.0.0.20", "status", "ONLINE")
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteGateway(@PathVariable int id) {
        return Map.of(
                "permission", "GATEWAY_DELETE",
                "message", "Gateway deleted",
                "id", id
        );
    }
}
