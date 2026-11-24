package com.orderhub.services;

import com.orderhub.execption.UserNotFoundException;
import com.orderhub.model.Users;
import com.orderhub.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users byusername = repository.findByusername(username);

       return User.builder()
                .username(username)
                .password(byusername.getPassword())
                .build();

    }
}
