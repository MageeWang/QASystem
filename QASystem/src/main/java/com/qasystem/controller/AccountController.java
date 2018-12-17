package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.Student;
import com.qasystem.service.implement.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private StudentImpl studentImpl;

    @RequestMapping(value = "/loginconfirm",method = RequestMethod.POST)
    @ResponseBody
    public Map loginConfirm(@RequestBody JSONObject jo, HttpSession session){
        String iden = jo.getString("iden");
        String username = jo.getString("username");
        String password = jo.getString("password");
        try {
            if(iden.equals("iden_admin")){
                if(username.equals("admin") && password.equals("admin")){
                    session.setAttribute("id",0);
                    session.setAttribute("username","admin");
                    session.setAttribute("iden",iden);
                    Map json = new HashMap();
                    json.put("result",1);
                    return json;
                }
            }else if(iden.equals("iden_teacher")){

            }else if(iden.equals("iden_student")){
                Student student = studentImpl.getStudentBySid(Long.parseLong(username));
                if(student.getSpsw().equals(password)){
                    session.setAttribute("id",student.getSid());
                    session.setAttribute("username",student.getSname());
                    session.setAttribute("info",student);
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
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpSession session, HttpServletResponse response){
        session.removeAttribute("id");
        session.removeAttribute("username");
        session.removeAttribute("iden");
        try {
            response.sendRedirect("/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
