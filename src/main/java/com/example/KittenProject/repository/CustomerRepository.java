package com.example.KittenProject.repository;

import com.example.KittenProject.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {

    Customers findByEmailAddress(String email);
}
