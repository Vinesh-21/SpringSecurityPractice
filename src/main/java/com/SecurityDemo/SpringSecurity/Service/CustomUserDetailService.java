package com.SecurityDemo.SpringSecurity.Service;

import com.SecurityDemo.SpringSecurity.Dto.RegisterRequest;
import com.SecurityDemo.SpringSecurity.Entity.Users;
import com.SecurityDemo.SpringSecurity.Repository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
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

        user.setRole("ROLE_USER");

        return userDetailsRepository.save(user);
    }
}
