package com.example.springbootcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping({"/login", "/login/"})
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("users/login");
        modelAndView.addObject("title", "Curso de Springboot - Login");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot - Inicia sesión aquí");
        return modelAndView;
    }
}
