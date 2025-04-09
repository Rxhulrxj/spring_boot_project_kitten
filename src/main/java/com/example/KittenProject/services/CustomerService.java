package com.example.KittenProject.services;

import com.example.KittenProject.model.Customers;
import com.example.KittenProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public Customers createAccount(Customers customerModel){
        customerModel.setPassword(passwordEncoder.encode(customerModel.getPassword()));
        return customerRepository.save(customerModel);
    }


}
