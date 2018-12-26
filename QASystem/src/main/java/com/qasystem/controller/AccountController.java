package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.*;
import com.qasystem.service.implement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private StudentImpl studentImpl;
    @Autowired
    private TeacherImpl teacherImpl;
    @Autowired
    private DepartmentImpl departmentImpl;

    @RequestMapping(value = "/login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
    @RequestMapping(value = "/register")
    public ModelAndView registerPage(){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }

    @RequestMapping(value = "/loginconfirm",method = RequestMethod.POST)
    @ResponseBody
    public Map loginConfirm(@RequestBody JSONObject jo, HttpSession session){
        String iden = jo.getString("iden");
        String username = jo.getString("username");
        String password = jo.getString("password");
        try {
            if(iden.equals("iden_admin")){
                if(username.equals("admin") && password.equals("admin")){
                    session.setAttribute("USER","admin");
                    session.setAttribute("iden",iden);
                    Map json = new HashMap();
                    json.put("result",1);
                    return json;
                }
            }else if(iden.equals("iden_teacher")){
                Teacher teacher = teacherImpl.getTeacherByTid(Long.parseLong(username));
                if(teacher.getTpsw().equals(password)){
                    session.setAttribute("USER",teacher);
                    session.setAttribute("iden",iden);
                    Map json = new HashMap();
                    json.put("result",1);
                    return json;
                }
            }else if(iden.equals("iden_student")){
                Student student = studentImpl.getStudentBySid(Long.parseLong(username));
                if(student.getSpsw().equals(password)){
                    session.setAttribute("USER",student);
                    session.setAttribute("iden",iden);
                    Map json = new HashMap();
                    json.put("result",1);
                    return json;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Map json = new HashMap();
        json.put("result",0);
        return json;
    }
    @RequestMapping(value = "/registerconfirm",method = RequestMethod.POST)
    public Map registerConfirm(@RequestBody JSONObject jsonObject){
        Student student = new Student();
        student.setSid(jsonObject.getLong("Sid"));
        student.setSname(jsonObject.getString("Sname"));
        student.setSpsw(jsonObject.getString("Spsw"));
        student.setDid(jsonObject.getLong("Did"));
        student.setDname(departmentImpl.getDeptByDid(jsonObject.getLong("Did")).getDname());
        student.setSyear(jsonObject.getString("Syear"));
        studentImpl.insert(student);
        Map result = new HashMap();
        result.put("result",1);
        return result;
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpSession session, HttpServletResponse response){
        session.removeAttribute("USER");
        session.removeAttribute("iden");
        try {
            response.sendRedirect("/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
