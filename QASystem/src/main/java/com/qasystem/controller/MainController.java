package com.qasystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qasystem.domain.*;
import com.qasystem.service.implement.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class MainController {
    @Autowired
    private QuestionImpl questionImpl;

    @RequestMapping(value = "/")
    public void index(HttpServletResponse response){
        try {
            response.sendRedirect("/index?page=1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/index")
    public ModelAndView mainPage(@Param("page") Integer page){
        ModelAndView modelAndView = new ModelAndView("/index");
        Map params = new HashMap();
        PageHelper.startPage(page,5);
        PageInfo<Question> pageInfo = new PageInfo<>(questionImpl.searchQuestionList(params));
        modelAndView.addObject("QuestionList",pageInfo.getList());
        List<Integer> pages = new ArrayList<>();
        for(int i = 1;i<=pageInfo.getPages();i++){
            pages.add(i);
        }
        modelAndView.addObject("pages",pages);
        return modelAndView;
    }
}
