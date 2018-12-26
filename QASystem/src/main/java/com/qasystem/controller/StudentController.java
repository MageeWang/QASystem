package com.qasystem.controller;

import com.qasystem.service.implement.QuestionImpl;
import com.qasystem.service.implement.StudentImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentImpl studentImpl;
    @Autowired
    private QuestionImpl questionImpl;

    @RequestMapping("/student")
    public ModelAndView studentPage(@Param("Sid") Long Sid){
        ModelAndView modelAndView = new ModelAndView("/student");
        Map param = new HashMap();
        param.put("Sid",Sid);
        modelAndView.addObject("Student",studentImpl.getStudentBySid(Sid));
        modelAndView.addObject("QuestionList",questionImpl.searchQuestionList(param));
        return modelAndView;
    }
}
