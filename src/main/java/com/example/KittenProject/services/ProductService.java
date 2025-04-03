package com.example.KittenProject.services;

import com.example.KittenProject.model.Products;
import com.example.KittenProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Products products){
        productRepository.save(products);
    }
}
