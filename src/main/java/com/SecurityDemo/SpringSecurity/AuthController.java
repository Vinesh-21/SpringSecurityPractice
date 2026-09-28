package com.SecurityDemo.SpringSecurity;

import com.SecurityDemo.SpringSecurity.Dto.RegisterRequest;
import com.SecurityDemo.SpringSecurity.Entity.Users;
import com.SecurityDemo.SpringSecurity.Service.CustomUserDetailService;
import com.SecurityDemo.SpringSecurity.Util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailService userDetailsService;
    private final AuthenticationManager authenticationManager;


    private final JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userDetailsService.usernameExists(request.getUsername())) {
            return ResponseEntity.ok("User already exists");
        }
        return ResponseEntity.ok(userDetailsService.registerUser(request));
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody RegisterRequest request){

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())); // Spring Security, please check whether this username and password are valid.
            return jwtUtil.generateToken(request.getUsername());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}