package com.SecurityDemo.SpringSecurity.Service;

import com.SecurityDemo.SpringSecurity.Dto.RegisterRequest;
import com.SecurityDemo.SpringSecurity.Entity.Roles;
import com.SecurityDemo.SpringSecurity.Entity.Users;
import com.SecurityDemo.SpringSecurity.Repository.RoleRepository;
import com.SecurityDemo.SpringSecurity.Repository.UserDetailsRepository;
import com.SecurityDemo.SpringSecurity.Security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // 1. Find user
        Users user = userDetailsRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found: " + username
            );
        }

        // 2. Find role
        Roles role = roleRepository.findByName(user.getRole());

        if (role == null) {
            throw new UsernameNotFoundException(
                    "Role not found: " + user.getRole()
            );
        }

        // 3. Create authorities
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Role authority
        authorities.add(
                new SimpleGrantedAuthority(
                        "ROLE_" + role.getName()
                )
        );

        // Permission authorities
        if (role.getPermission() != null) {

            role.getPermission().forEach(permission ->
                    authorities.add(
                            new SimpleGrantedAuthority(
                                    permission.name()
                            )
                    )
            );
        }

        // 4. Return Spring Security object

        logger.info("User: {} ,Role: {} ,Authorities :{}",user.getUsername(),user.getRole(),authorities);

        return new CustomUserDetails(
                user,
                authorities
        );
    }

    public boolean usernameExists(String username) {
        return userDetailsRepository.findByUsername(username) != null;
    }

    public Users registerUser(RegisterRequest request) {

        Users user = new Users();

        user.setUsername(request.getUsername());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(request.getRole());

        return userDetailsRepository.save(user);
    }
}