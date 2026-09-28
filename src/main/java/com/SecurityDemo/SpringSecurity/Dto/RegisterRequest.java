package com.SecurityDemo.SpringSecurity.Dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
}