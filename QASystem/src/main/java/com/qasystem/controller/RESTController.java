package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.Course;
import com.qasystem.domain.Department;
import com.qasystem.service.implement.CourseImpl;
import com.qasystem.service.implement.DepartmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RESTController {
    @Autowired
    private DepartmentImpl departmentImpl;
    @Autowired
    private CourseImpl courseImpl;

    @RequestMapping("/getDeptList")
    @ResponseBody
    public Map<String,List<Department>> getDeptList(){
        List<Department> DeptList = departmentImpl.getDeptList();
        Map result = new HashMap();
        result.put("DeptList",DeptList);
        return result;
    }
    @ResponseBody
    @RequestMapping("/getMajorList")
    public Map<String, Course> getCourseList(@RequestBody JSONObject jsonObject){
        Map result = new HashMap();
        List<Course> CourseList = courseImpl.getCourseListByDid(jsonObject.getLong("Did"));
        result.put("CourseList",CourseList);
        return result;
    }
//    @ResponseBody
//    @RequestMapping("/getCourseMap")
//    public Map<String,Course> getCourseList(@RequestBody JSONObject jsonObject){
//
//    }
//    @ResponseBody
//    @RequestMapping("/getTeacherMap")
//    public Map<String,Teacher> getTeacherList(@RequestBody JSONObject jsonObject) {
//
//    }
}
