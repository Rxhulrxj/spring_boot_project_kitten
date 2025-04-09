package com.example.KittenProject.controller;


import com.example.KittenProject.model.ProductStatus;
import com.example.KittenProject.model.Products;
import com.example.KittenProject.services.CategoryService;
import com.example.KittenProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    //TODO : add bean validation to the add products
    @GetMapping("products/add")
    public String addProduct(Model model){
        model.addAttribute("product",new Products());
        model.addAttribute("categories",categoryService.getCategoryList());
        model.addAttribute("status", ProductStatus.values());
        return "admin/addProduct";
    }

    @PostMapping("products/save")
    public String saveProduct(@ModelAttribute("product")Products products, @RequestParam("productPhoto")MultipartFile file) throws IOException {
        products.setProductPhoto(file.getBytes());
        productService.addProduct(products);
        return "redirect:/products/listProducts";
    }

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "admin/dashboard";
    }

    @GetMapping("products/listProducts")
    public String listProducts(){
        return "admin/product-list";
    }


}
