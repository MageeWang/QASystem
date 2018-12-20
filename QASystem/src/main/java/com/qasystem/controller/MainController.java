package com.qasystem.controller;

import com.qasystem.service.implement.DepartmentImpl;
import com.qasystem.service.implement.QuestionImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "")
public class MainController {
    @Autowired
    private DepartmentImpl departmentImpl;
    @Autowired
    private QuestionImpl questionImpl;

    @RequestMapping(value = "/")
    public ModelAndView mainPage(HttpSession session){
        //session.setAttribute("DeptList",departmentImpl.getDeptList());
        //session.setAttribute("QuestionList",questionImpl.searchQuestionList(new HashMap<>()));
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("QuestionList",questionImpl.searchQuestionList(new HashMap<>()));
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
        ModelAndView modelAndView = new ModelAndView("/manage/manage");
        return modelAndView;
    }
    @RequestMapping(value = "/manage/dept")
    public ModelAndView manageDeptPage(){
        ModelAndView modelAndView = new ModelAndView("/manage/dept");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }
    @RequestMapping(value = "/manage/major")
    public ModelAndView manageMajorPage(){
        ModelAndView modelAndView = new ModelAndView("/manage/major");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }
    @RequestMapping(value = "/manage/course")
    public ModelAndView manageCoursePage(){
        ModelAndView modelAndView = new ModelAndView("/manage/course");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }
    @RequestMapping(value = "/manage/teacher")
    public ModelAndView manageTeacherPage(){
        ModelAndView modelAndView = new ModelAndView("/manage/teacher");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }
    @RequestMapping(value = "/question",method = RequestMethod.GET)
    public ModelAndView questionPage(@Param("Qid")Long Qid,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/question");
        modelAndView.addObject("Question",questionImpl.getQuestion(Qid));
        return modelAndView;
    }
}
