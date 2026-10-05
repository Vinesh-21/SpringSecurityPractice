package com.SecurityDemo.SpringSecurity.Dto;

import com.SecurityDemo.SpringSecurity.Enums.Permissions;
import lombok.Data;

import java.util.Set;

@Data
public class CreateRoleRequest {

    private String name;
    private String roleDescription;
    private Set<Permissions> permission;
}
