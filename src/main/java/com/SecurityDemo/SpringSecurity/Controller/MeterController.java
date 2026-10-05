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
@RequestMapping("/api/meters")
public class MeterController {

    @GetMapping
    public Map<String, Object> viewMeters() {
        return Map.of(
                "permission", "METER_VIEW",
                "meters", List.of(
                        Map.of("id", 1, "serial", "MTR-1001", "readingKwh", 1520.4),
                        Map.of("id", 2, "serial", "MTR-1002", "readingKwh", 876.1)
                )
        );
    }

    @PostMapping
    public Map<String, Object> addMeter() {
        return Map.of(
                "permission", "METER_ADD",
                "message", "Meter created",
                "meter", Map.of("id", 3, "serial", "MTR-1003", "readingKwh", 0.0)
        );
    }

    @PutMapping("/{id}")
    public Map<String, Object> editMeter(@PathVariable int id) {
        return Map.of(
                "permission", "METER_EDIT",
                "message", "Meter updated",
                "meter", Map.of("id", id, "serial", "MTR-UPDATED", "readingKwh", 1600.0)
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteMeter(@PathVariable int id) {
        return Map.of(
                "permission", "METER_DELETE",
                "message", "Meter deleted",
                "id", id
        );
    }
}
