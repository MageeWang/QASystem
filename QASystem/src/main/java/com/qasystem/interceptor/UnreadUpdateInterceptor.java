package com.qasystem.interceptor;

import com.qasystem.domain.Answer;
import com.qasystem.domain.Question;
import com.qasystem.domain.Student;
import com.qasystem.domain.Teacher;
import com.qasystem.service.implement.AnswerImpl;
import com.qasystem.service.implement.QuestionImpl;
import com.qasystem.service.implement.TeacherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnreadUpdateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        return true;
    }

    @Autowired
    private QuestionImpl questionImpl;
    @Autowired
    private TeacherImpl teacherImpl;

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        try {
            HttpSession session = httpServletRequest.getSession();
            if (modelAndView != null && session.getAttribute("USER") != null) {
                String iden = (String)session.getAttribute("iden");
                if (iden.equals("iden_student")) {
                    Map param = new HashMap();
                    Student student = (Student) session.getAttribute("USER");
                    param.put("Sid",student.getSid());
                    List<Question> unread = questionImpl.searchQuestionList(param);
                    int unreadNum = 0;
                    for(int i = 0;i<unread.size();i++){
                        unreadNum += unread.get(i).getQunread();
                    }
                    modelAndView.addObject("UnreadNum",unreadNum);
                } else if (iden.equals("iden_teacher")) {
                    Teacher teacher = (Teacher) session.getAttribute("USER");
                    if(teacher!=null)
                        modelAndView.addObject("UnansweredNum",teacherImpl.getUnAnsweredQuestionList(teacher.getTid()).size());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
