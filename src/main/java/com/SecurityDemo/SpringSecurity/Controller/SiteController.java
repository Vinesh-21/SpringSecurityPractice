package com.SecurityDemo.SpringSecurity.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/sites")
public class SiteController {

    @GetMapping
    @PreAuthorize("hasAuthority('SITE_VIEW')")
    public Map<String, Object> viewSites() {
        return Map.of(
                "permission", "SITE_VIEW",
                "sites", List.of(
                        Map.of("id", 1, "name", "Main Plant", "location", "Chennai"),
                        Map.of("id", 2, "name", "Backup Plant", "location", "Bengaluru")
                )
        );
    }

    @PostMapping
    public Map<String, Object> addSite() {
        return Map.of(
                "permission", "SITE_ADD",
                "message", "Site created",
                "site", Map.of("id", 3, "name", "New Plant", "location", "Hyderabad")
        );
    }

    @PutMapping("/{id}")
    public Map<String, Object> editSite(@PathVariable int id) {
        return Map.of(
                "permission", "SITE_EDIT",
                "message", "Site updated",
                "site", Map.of("id", id, "name", "Updated Plant", "location", "Mumbai")
        );
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteSite(@PathVariable int id) {
        return Map.of(
                "permission", "SITE_DELETE",
                "message", "Site deleted",
                "id", id
        );
    }
}
