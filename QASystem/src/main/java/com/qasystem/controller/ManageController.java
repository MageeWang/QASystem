package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.*;
import com.qasystem.service.implement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/manage")
public class ManageController {
    @Autowired
    private DepartmentImpl departmentImpl;
    @Autowired
    private CourseImpl courseImpl;
    @Autowired
    private TeachImpl teachImpl;
    @Autowired
    private TeacherImpl teacherImpl;

    @RequestMapping(value = "/addDept",method = RequestMethod.POST)
    @ResponseBody
    public Map addDept(@RequestBody JSONObject jsonObject){
        Long Did = jsonObject.getLong("Did");
        String Dname = jsonObject.getString("Dname");
        String Dinfo = jsonObject.getString("Dinfo");
        Department department = new Department();
        department.setDid(Did);
        department.setDname(Dname);
        department.setDinfo(Dinfo);
        Map result = new HashMap();
        if (departmentImpl.insert(department) == 1) {
            result.put("result", 1);
            return result;
        }else{
            result.put("result", 0);
            return result;
        }
    }

    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    @ResponseBody
    public Map addCourse(@RequestBody JSONObject jsonObject){
        Course course = new Course();
        course.setCid(jsonObject.getLong("Cid"));
        course.setCname(jsonObject.getString("Cname"));
        course.setCinfo(jsonObject.getString("Cinfo"));
        course.setDid(jsonObject.getLong("Did"));
        course.setDname(departmentImpl.getDeptByDid(jsonObject.getLong("Did")).getDname());
        Map result = new HashMap();
        if (courseImpl.insert(course)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }

    @RequestMapping(value = "/addTeach",method = RequestMethod.POST)
    @ResponseBody
    public Map addTeach(@RequestBody JSONObject jsonObject){
        Teach teach = new Teach();
        teach.setCid(jsonObject.getLong("Cid"));
        teach.setCname(courseImpl.getCourseByCid(jsonObject.getLong("Cid")).getCname());
        teach.setTid(jsonObject.getLong("Tid"));
        teach.setTname(teacherImpl.getTeacherByTid(jsonObject.getLong("Tid")).getTname());
        Map result = new HashMap();
        if(teachImpl.insert(teach)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }

    @RequestMapping(value = "/addTeacher",method = RequestMethod.POST)
    @ResponseBody
    public Map addTeacher(@RequestBody JSONObject jsonObject){
        Teacher teacher = new Teacher();
        teacher.setTid(jsonObject.getLong("Tid"));
        teacher.setTname(jsonObject.getString("Tname"));
        teacher.setTpsw(jsonObject.getString("Tpsw"));
        teacher.setDid(jsonObject.getLong("Did"));
        teacher.setDname(departmentImpl.getDeptByDid(jsonObject.getLong("Did")).getDname());
        teacher.setTinfo(jsonObject.getString("Tinfo"));
        teacher.setTlevel(jsonObject.getString("Tlevel"));
        Map result = new HashMap();
        if(teacherImpl.insert(teacher)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }

    @RequestMapping(value = "/deleteDept",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteDept(@RequestBody JSONObject jsonObject){
        Department department = new Department();
        department.setDid(jsonObject.getLong("Did"));
        Map result = new HashMap();
        if (departmentImpl.delete(department) == 1) {
            result.put("result", 1);
            return result;
        }else{
            result.put("result", 0);
            return result;
        }
    }

    @RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteCourse(@RequestBody JSONObject jsonObject){
        Course course = new Course();
        course.setCid(jsonObject.getLong("Cid"));
        Map result = new HashMap();
        if (courseImpl.delete(course)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }

    @RequestMapping(value = "/deleteTeach",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteTeach(@RequestBody JSONObject jsonObject){
        Teach teach = new Teach();
        teach.setCid(jsonObject.getLong("Cid"));
        teach.setTid(jsonObject.getLong("Tid"));
        Map result = new HashMap();
        if(teachImpl.delete(teach)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }

    @RequestMapping(value = "/deleteTeacher",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteTeacher(@RequestBody JSONObject jsonObject){
        Teacher teacher = new Teacher();
        teacher.setTid(jsonObject.getLong("Tid"));
        Map result = new HashMap();
        if(teacherImpl.delete(teacher)==1){
            result.put("result",1);
            return result;
        }else {
            result.put("result",0);
            return result;
        }
    }
}
