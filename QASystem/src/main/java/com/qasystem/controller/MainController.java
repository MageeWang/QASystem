package com.qasystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "")
public class MainController {
    @RequestMapping(value = "/")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
    @RequestMapping(value = "/register")
    public ModelAndView registerPage(){
        ModelAndView modelAndView = new ModelAndView("/register");
        return modelAndView;
    }
    @RequestMapping(value = "/manage")
    public ModelAndView managePage(){
        ModelAndView modelAndView = new ModelAndView("/manage");
        return modelAndView;
    }
}
