package com.example.KittenProject.services;

import com.example.KittenProject.model.Customers;
import com.example.KittenProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public Customers createAccount(Customers customerModel){
        return customerRepository.save(customerModel);
    }


    public Customers loginUser(Customers customers){
        Customers customers1 = customerRepository.findByEmailAddress(customers.getEmailAddress());
        if(customers1.getEmailAddress() !=null && customers1.getPassword().equals(customers.getPassword())){
            return customers1;
        }
        return null;
    }

}
