package com.example.KittenProject.services;

import com.example.KittenProject.config.UserInfoDetails;
import com.example.KittenProject.model.Customers;
import com.example.KittenProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customers> customers = customerRepository.findByEmailAddress(username);
        return customers.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

    }
}
