package com.SecurityDemo.SpringSecurity;

import com.SecurityDemo.SpringSecurity.Dto.RegisterRequest;
import com.SecurityDemo.SpringSecurity.Entity.Users;
import com.SecurityDemo.SpringSecurity.Service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userDetailsService.usernameExists(request.getUsername())) {
            return ResponseEntity.ok("User already exists");
        }
        return ResponseEntity.ok(userDetailsService.registerUser(request));
    }

}