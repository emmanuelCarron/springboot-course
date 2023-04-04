package com.example.springbootcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/params")
public class RequestParamsController {
    @GetMapping("/redirect")
    public ModelAndView redirigir(ModelAndView modelAndView) {
        modelAndView.setViewName("request-params/index");
        modelAndView.addObject("title", "Curso de Springboot - Enviar params");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot - Enviar parámetros del request http (redirigir a otro endpoint)");
        return modelAndView;
    }

    @GetMapping("/request")
    public ModelAndView ver(@RequestParam(name = "texto", required = false, defaultValue = "default...") String text, ModelAndView modelAndView) {
        modelAndView.setViewName("request-params/params");
        modelAndView.addObject("title", "Curso de Springboot - Request params");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot - Request params");
        modelAndView.addObject("concept", "El texto recibido como request param es: " + text);
        return modelAndView;
    }

    @GetMapping("/saludar")
    public ModelAndView saludar(@RequestParam String nombre,
                                @RequestParam Integer cantidad,
                                ModelAndView modelAndView) {
        String beso = cantidad > 1 ? "besos" : "beso";
        modelAndView.setViewName("request-params/saludo");
        modelAndView.addObject("title", "Curso de Springboot - Saludar");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot - Saludar con varios params");
        modelAndView.addObject("saludo", cantidad + " " + beso + " para " + nombre);
        return modelAndView;
    }

    @GetMapping("/saludarv2")
    public ModelAndView saludarV2(HttpServletRequest request,
                                ModelAndView modelAndView) {
        String nombre = request.getParameter("nombre");
        int cantidad;
        try {
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
        } catch ( NumberFormatException e ) {
            cantidad = 0;
        }
        String beso = cantidad > 1 ? "besos" : "beso";
        modelAndView.setViewName("request-params/saludo");
        modelAndView.addObject("title", "Curso de Springboot - Saludar V2");
        modelAndView.addObject("body_title", "Bienvenido a SpringBoot - Saludar V2 con varios params");
        modelAndView.addObject("saludo", cantidad + " " + beso + " para " + nombre);
        return modelAndView;
    }
}
