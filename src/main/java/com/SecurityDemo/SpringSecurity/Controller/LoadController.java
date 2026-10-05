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
@RequestMapping("/api/loads")
public class LoadController {

    @GetMapping
    public Map<String, Object> viewLoads() {
        return Map.of(
                "permission", "LOAD_VIEW",
                "loads", List.of(
                        Map.of("id", 1, "name", "HVAC", "kw", 42.5),
                        Map.of("id", 2, "name", "Lighting", "kw", 12.0)
                )
        );
    }

    @PostMapping
    public Map<String, Object> addLoad() {
        return Map.of(
                "permission", "LOAD_ADD",
                "message", "Load created",
                "load", Map.of("id", 3, "name", "Pump", "kw", 18.75)
        );
    }

    @PutMapping("/{id}")
    public Map<String, Object> editLoad(@PathVariable int id) {
        return Map.of(
                "permission", "LOAD_EDIT",
                "message", "Load updated",
                "load", Map.of("id", id, "name", "Updated Load", "kw", 20.0)
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteLoad(@PathVariable int id) {
        return Map.of(
                "permission", "LOAD_DELETE",
                "message", "Load deleted",
                "id", id
        );
    }
}
