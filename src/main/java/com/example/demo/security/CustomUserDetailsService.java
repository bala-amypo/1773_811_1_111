package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Static demo user for academic project
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                "admin",
                "{noop}admin123",
                Collections.singleton(
                        () -> "ROLE_ADMIN"
                )
        );
    }
}
