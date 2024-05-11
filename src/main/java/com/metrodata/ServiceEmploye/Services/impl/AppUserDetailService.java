package com.metrodata.ServiceEmploye.Services.impl;

import com.metrodata.ServiceEmploye.Models.AppUserDetail;
import com.metrodata.ServiceEmploye.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsernameOrEmployee_Email(username, username)
                .map(AppUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username or Email not found"));
    }
}
