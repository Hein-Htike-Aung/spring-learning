package com.example.securityproject.security;

import com.example.securityproject.entity.Users;
import com.example.securityproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // CustomUserDetailsService is for building user with UserDetails
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // find User with its username
        // username came from UI
        Users user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with this username."));


        return new CustomUserDetails(user);
    }
}
