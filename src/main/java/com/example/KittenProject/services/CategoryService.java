package com.example.KittenProject.services;

import com.example.KittenProject.model.Category;
import com.example.KittenProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }


    public void editCategory(Category category){
        categoryRepository.save(category);
    }
}
