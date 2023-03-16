package com.example.springbootcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class IndexController {
    @GetMapping({"/", "/index", "/index/"})
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "Curso de Springboot");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot");
        return modelAndView;
    }
}
