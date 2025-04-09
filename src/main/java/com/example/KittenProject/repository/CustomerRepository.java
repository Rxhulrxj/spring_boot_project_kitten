package com.example.KittenProject.repository;

import com.example.KittenProject.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {

    Optional<Customers> findByEmailAddress(String email);
}
