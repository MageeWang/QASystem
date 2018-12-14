package com.qa.qasystem.controller;

import com.qa.qasystem.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView showLogin(){
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("User",new User(null,null));
        return modelAndView;
    }
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public ModelAndView showInfo(@ModelAttribute(value = "User")User user){
        ModelAndView modelAndView = new ModelAndView("/info");
        return modelAndView;
    }
}
