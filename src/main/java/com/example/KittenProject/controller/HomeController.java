package com.example.KittenProject.controller;


import com.example.KittenProject.model.Customers;
import com.example.KittenProject.services.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("customer")Customers customers, HttpServletRequest request){
        Customers customers1 = customerService.loginUser(customers);
        if(customers1 !=null){
            request.getSession().setAttribute("isLoggedIn",true);
            request.getSession().setAttribute("email",customers1.getEmailAddress());
            request.getSession().setAttribute("fullName",customers1.getFullName());
            return "redirect:/";
        }
        return "index";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request){
//        request.c
//    }

    @GetMapping("/register")
    public String createUserViewPage(Model model){
        model.addAttribute("customer",new Customers());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("customer")Customers customers, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        //db logic
        customerService.createAccount(customers);

        return "register";
    }
}
