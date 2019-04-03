package com.qasystem.controller;

import com.qasystem.domain.Answer;
import com.qasystem.domain.Question;
import com.qasystem.domain.Teach;
import com.qasystem.domain.Teacher;
import com.qasystem.service.implement.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NavController {
    @Autowired
    private DepartmentImpl departmentImpl;
    @Autowired
    private CourseImpl courseImpl;
    @Autowired
    private QuestionImpl questionImpl;
    @Autowired
    private TeachImpl teachImpl;
    @Autowired
    private TeacherImpl teacherImpl;
    @Autowired
    private AnswerImpl answerImpl;

    @RequestMapping(value = "/department")
    public ModelAndView deptPage(@Param("Did") Long Did){
        ModelAndView modelAndView = new ModelAndView("/department");
        if(Did==null)
            modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        else {
            modelAndView.addObject("Dept",departmentImpl.getDeptByDid(Did));
            modelAndView.addObject("CourseList",courseImpl.getCourseListByDid(Did));
            Map param = new HashMap();
            param.put("Did",Did);
            modelAndView.addObject("QuestionList",questionImpl.searchQuestionList(param));
        }
        return modelAndView;
    }
    @RequestMapping(value = "/course")
    public ModelAndView coursePage(@Param("Cid") Long Cid,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/course");
        if(Cid==null) {
            modelAndView.addObject("DeptList", departmentImpl.getDeptList());
            modelAndView.addObject("editable", false);
        } else {
            Map param = new HashMap();
            param.put("Cid",Cid);
            List<Teach> TeachList = teachImpl.getCourseListByCid(Cid);
            List<Teacher> TeacherList = teacherImpl.getTeacherListByDid(courseImpl.getCourseByCid(Cid).getDid());
            modelAndView.addObject("Course",courseImpl.getCourseByCid(Cid));
            modelAndView.addObject("TeacherList",TeachList);
            modelAndView.addObject("QuestionList",questionImpl.searchQuestionList(param));
            modelAndView.addObject("editable",true);
            modelAndView.addObject("AllTeacherList",TeacherList);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/teacher")
    public ModelAndView teacherPage(@Param("Tid") Long Tid, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/teacher");
        if(Tid==null){
            modelAndView.addObject("DeptList",departmentImpl.getDeptList());
            modelAndView.addObject("editable", false);
        }else{
            modelAndView.addObject("Teacher",teacherImpl.getTeacherByTid(Tid));
            modelAndView.addObject("TeachList",teachImpl.getCourseListByTid(Tid));
            modelAndView.addObject("AnswerList",answerImpl.getAnswerListByTid(Tid));
            modelAndView.addObject("editable",true);
            modelAndView.addObject("AllCourseList",courseImpl.getCourseListByDid(teacherImpl.getTeacherByTid(Tid).getDid()));
            Map<Long,Question> QuestionMap = new HashMap<>();
            List<Answer> AnswerList = answerImpl.getAnswerListByTid(Tid);
            for(int i = 0;i<AnswerList.size();i++){
                QuestionMap.put(AnswerList.get(i).getQid(),questionImpl.getQuestion(AnswerList.get(i).getQid()));
            }
            modelAndView.addObject("QuestionMap",QuestionMap);
            if(session.getAttribute("USER")!=null){
                if(session.getAttribute("iden").equals("iden_teacher")) {
                    Teacher teacher = (Teacher) session.getAttribute("USER");
                    if (teacher.getTid().equals(Tid)) {
                        modelAndView.addObject("UnansweredList", teacherImpl.getUnAnsweredQuestionList(Tid));
                        modelAndView.addObject("isMine", true);
                    }
                }
            }
        }
        return modelAndView;
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView searchPage(){
        ModelAndView modelAndView = new ModelAndView("/search");
        return modelAndView;
    }
}
