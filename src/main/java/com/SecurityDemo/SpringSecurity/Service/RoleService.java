package com.SecurityDemo.SpringSecurity.Service;

import com.SecurityDemo.SpringSecurity.Dto.CreateRoleRequest;
import com.SecurityDemo.SpringSecurity.Entity.Roles;
import com.SecurityDemo.SpringSecurity.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public boolean roleExists(String name) {
        return roleRepository.findByName(name) != null;
    }

    public Roles createRole(CreateRoleRequest request) {
        Roles role = new Roles();
        role.setName(request.getName().trim());
        role.setRoleDescription(request.getRoleDescription());
        role.setPermission(request.getPermission() == null
                ? new HashSet<>()
                : new HashSet<>(request.getPermission()));
        // Public creates are never built-in roles.
        role.setSystemRole(false);
        return roleRepository.save(role);
    }

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    public Roles findByName(String name) {
        return roleRepository.findByName(name);
    }
}
