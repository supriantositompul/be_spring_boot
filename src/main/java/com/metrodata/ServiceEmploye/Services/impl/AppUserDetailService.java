package com.metrodata.ServiceEmploye.Services.impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metrodata.ServiceEmploye.Models.AppUserDetail;
import com.metrodata.ServiceEmploye.Models.Entity.User;
import com.metrodata.ServiceEmploye.Repositories.UserRepository;

@Service
public class AppUserDetailService implements UserDetailsService{
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository
                .findByUsernameOrEmployee_Email(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or Email not found!!"));

        return new AppUserDetail(user);
    }

}
