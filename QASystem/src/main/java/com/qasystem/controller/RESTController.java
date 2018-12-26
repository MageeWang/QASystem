package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.Course;
import com.qasystem.domain.Department;
import com.qasystem.domain.Teacher;
import com.qasystem.service.implement.*;
import com.qasystem.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private QuestionImpl questionImpl;
    @Autowired
    private TeacherImpl teacherImpl;
    @Autowired
    private AnswerImpl answerImpl;

    @RequestMapping("/getDeptList")
    @ResponseBody
    public Map<String,List<Department>> getDeptList(){
        List<Department> DeptList = departmentImpl.getDeptList();
        Map result = new HashMap();
        result.put("DeptList",DeptList);
        return result;
    }
    @RequestMapping("/getDeptByDid")
    @ResponseBody
    public Map<String,Department> getDeptByDid(@RequestBody JSONObject jsonObject){
        Department department = departmentImpl.getDeptByDid(jsonObject.getLong("Did"));
        Map result = new HashMap();
        result.put("dept",department);
        return result;
    }

    @RequestMapping("/getCourseByCid")
    @ResponseBody
    public Map<String,Course> getCourseByCid(@RequestBody JSONObject jsonObject){
        Course course = courseImpl.getCourseByCid(jsonObject.getLong("Cid"));
        Map result = new HashMap();
        result.put("course",course);
        return result;
    }

    @RequestMapping("/getTeacherByTid")
    @ResponseBody
    public Map<String,Teacher> getTeacherByTid(@RequestBody JSONObject jsonObject){
        Teacher teacher = teacherImpl.getTeacherByTid(jsonObject.getLong("Tid"));
        Map result = new HashMap();
        result.put("teacher",teacher);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getCourseList")
    public Map<String, Course> getCourseList(@RequestBody JSONObject jsonObject){
        Map result = new HashMap();
        List<Course> CourseList = courseImpl.getCourseListByDid(jsonObject.getLong("Did"));
        result.put("CourseList",CourseList);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getSearchList",method = RequestMethod.POST)
    public Map<String,List> getSearchResult(@RequestBody JSONObject jsonObject){
        Map result = new HashMap();
        Map<String,Object> param = new HashMap<>();
        String searchType = jsonObject.getString("searchType");
        String searchParam = jsonObject.getString("searchParam");
        param.put(searchType,searchParam);
        result.put("SearchList",questionImpl.searchQuestionList(param));
        return result;
    }
    @ResponseBody
    @RequestMapping("/getTeacherList")
    public Map<String,Teacher> getTeacherList(@RequestBody JSONObject jsonObject) {
        Map result = new HashMap();
        List<Teacher> TeacherList = teacherImpl.getTeacherListByDid(jsonObject.getLong("Did"));
        result.put("TeacherList",TeacherList);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getAnswer",method = RequestMethod.POST)
    public Map<String,Teacher> getAnswer(@RequestBody JSONObject jsonObject, HttpSession session) {
        Map result = new HashMap();
        Teacher teacher = (Teacher) session.getAttribute("USER");
        result.put("Answer",answerImpl.getAnswer(jsonObject.getLong("Qid"),teacher.getTid()));
        return result;
    }
}
