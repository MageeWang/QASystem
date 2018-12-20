package com.qasystem.controller;

import com.github.pagehelper.PageInfo;
import com.qasystem.domain.Student;
import com.qasystem.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import com.qasystem.tools.ServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RequestMapping("/StudentList")
//    @ResponseBody
//    public void queryStudentList(HttpServletRequest request, HttpServletResponse response){
//        try {
//            String page = "1"; // 取得当前页数,注意这是jqgrid自身的参数
//            String rows = "5";
//            Map<String,Object> params = new HashMap<String,Object>();
//            params.put("page", page);
//            params.put("rows", rows);
//            List<Student> StudentList = studentService.queryStudentList(params);
//            PageInfo<Student> pageInfo =new PageInfo<>(StudentList);
//            JSONObject jo=new JSONObject();
//            jo.put("rows", StudentList);
//            jo.put("total", pageInfo.getPages());//总页数
//            jo.put("records",pageInfo.getTotal());//查询出的总记录数
//            ServletUtil.createSuccessResponse(200, jo, response);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
