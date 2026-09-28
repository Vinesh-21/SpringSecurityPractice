package com.SecurityDemo.SpringSecurity.Service;

import com.SecurityDemo.SpringSecurity.Dto.RegisterRequest;
import com.SecurityDemo.SpringSecurity.Entity.Users;
import lombok.RequiredArgsConstructor;
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
    public Users register(@RequestBody RegisterRequest request) {
        return userDetailsService.registerUser(request);
    }

}