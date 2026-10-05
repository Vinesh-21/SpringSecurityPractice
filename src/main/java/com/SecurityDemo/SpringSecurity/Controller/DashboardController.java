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
@RequestMapping("/api/dashboards")
public class DashboardController {

    @GetMapping
    public Map<String, Object> viewDashboards() {
        return Map.of(
                "permission", "DASHBOARD_VIEW",
                "dashboards", List.of(
                        Map.of("id", 1, "name", "Operations", "widgets", 4),
                        Map.of("id", 2, "name", "Energy Overview", "widgets", 6)
                )
        );
    }

    @PostMapping
    public Map<String, Object> addDashboard() {
        return Map.of(
                "permission", "DASHBOARD_ADD",
                "message", "Dashboard created",
                "dashboard", Map.of("id", 3, "name", "New Dashboard", "widgets", 1)
        );
    }

    @PutMapping("/{id}")
    public Map<String, Object> editDashboard(@PathVariable int id) {
        return Map.of(
                "permission", "DASHBOARD_EDIT",
                "message", "Dashboard updated",
                "dashboard", Map.of("id", id, "name", "Updated Dashboard", "widgets", 5)
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteDashboard(@PathVariable int id) {
        return Map.of(
                "permission", "DASHBOARD_DELETE",
                "message", "Dashboard deleted",
                "id", id
        );
    }
}
