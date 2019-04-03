package com.qasystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.qasystem.domain.*;
import com.qasystem.service.implement.*;
import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    private QuestionImpl questionImpl;
    @Autowired
    private AnswerImpl answerImpl;
    @Autowired
    private TeachImpl teachImpl;
    @Autowired
    private DepartmentImpl departmentImpl;
    @Autowired
    private CourseImpl courseImpl;
    @Autowired
    private TeacherImpl teacherImpl;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/question",method = RequestMethod.GET)
    public ModelAndView questionPage(@Param("Qid")Long Qid, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/question");
        Question question0 = questionImpl.getQuestion(Qid);
        modelAndView.addObject("Question",question0);
        modelAndView.addObject("AnswerList",answerImpl.getAnswerListByQid(Qid));
        if(session.getAttribute("iden")!=null&&session.getAttribute("USER")!=null){
            if(session.getAttribute("iden").equals("iden_teacher")) {
                boolean answerable = false;
                boolean isAnswered = true;
                Teacher teacher = (Teacher) session.getAttribute("USER");
                List<Teach> teaches = teachImpl.getCourseListByTid(teacher.getTid());
                Question question = questionImpl.getQuestion(Qid);
                for (int i = 0; i < teaches.size(); i++) {
                    if (question.getCid().equals(teaches.get(i).getCid())) {
                        answerable = true;
                        break;
                    }
                }
                modelAndView.addObject("isAnswerable", answerable);
                List<Question> UnansweredList = teacherImpl.getUnAnsweredQuestionList(teacher.getTid());
                for(int i = 0;i<UnansweredList.size();i++){
                    if(UnansweredList.get(i).getQid().equals(question.getQid())){
                        isAnswered = false;
                        break;
                    }
                }
                modelAndView.addObject("isAnswered",isAnswered);
            }else if(session.getAttribute("iden").equals("iden_student")){
                Student student = (Student) session.getAttribute("USER");
                if(student.getSid().equals(question0.getSid())){
                    questionImpl.updateUnread(question0.getQid(),0);
                }
            }
        }
        return modelAndView;
    }
    @RequestMapping(value = "/ask",method = RequestMethod.GET)
    public ModelAndView askPage(){
        ModelAndView modelAndView = new ModelAndView("/ask");
        modelAndView.addObject("DeptList",departmentImpl.getDeptList());
        return modelAndView;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView editQuestionPage(@Param("Qid") Long Qid){
        ModelAndView modelAndView = new ModelAndView("/ask");
        modelAndView.addObject("Question",questionImpl.getQuestion(Qid));
        return modelAndView;
    }

    @RequestMapping(value = "/editQuestion",method = RequestMethod.POST)
    public Map editQuestion(@RequestBody JSONObject jsonObject){
        Map result = new HashMap();
        questionImpl.updateQuestion(jsonObject.getLong("Qid"),jsonObject.getString("Qtitle"),jsonObject.getString("Qtext"),simpleDateFormat.format(new Date()),questionImpl.getQuestion(jsonObject.getLong("Qid")).isQfile());
        result.put("Qid",jsonObject.getLong("Qid"));
        return result;
    }

    @RequestMapping(value = "/editAnswer",method = RequestMethod.POST)
    public Map editAnswer(@RequestBody JSONObject jsonObject,HttpSession session){
        Map result = new HashMap();
        Teacher teacher = (Teacher)session.getAttribute("USER");
        answerImpl.update(jsonObject.getLong("Qid"),teacher.getTid(),jsonObject.getString("Atext"),simpleDateFormat.format(new Date()));
        result.put("Qid",jsonObject.getLong("Qid"));
        return result;
    }

    @RequestMapping(value = "/addQuestion",method = RequestMethod.POST)
    public Map addQuestion(@RequestBody JSONObject jsonObject, HttpSession session){
        Question question = new Question();
        Student student = (Student) session.getAttribute("USER");
        question.setSid(student.getSid());
        question.setSname(student.getSname());
        question.setCid(jsonObject.getLong("Cid"));
        question.setCname(courseImpl.getCourseByCid(jsonObject.getLong("Cid")).getCname());
        question.setDid(jsonObject.getLong("Did"));
        question.setDname(departmentImpl.getDeptByDid(jsonObject.getLong("Did")).getDname());
        question.setQtitle(jsonObject.getString("Qtitle"));
        question.setQtext(jsonObject.getString("Qtext"));
        question.setQtime(simpleDateFormat.format(new Date()));
        question.setQfile(false);
        question.setQunread(0);
        questionImpl.insert(question);
        Map result = new HashMap();
        result.put("result",1);
        return result;
    }

    @RequestMapping(value = "/deleteQuestion")
    public void deleteQuestion(@Param("Qid") Long Qid, HttpServletResponse response){
        questionImpl.delete(Qid);
        answerImpl.deleteByQid(Qid);
        try {
            response.sendRedirect("http://localhost:8080");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/deleteAnswer",method = RequestMethod.POST)
    public Map deleteAnswer(@RequestBody JSONObject jsonObject,HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("USER");
        answerImpl.delete(jsonObject.getLong("Qid"),teacher.getTid());
        Map result = new HashMap();
        result.put("result",1);
        return result;
    }

    @RequestMapping(value = "/addAnswer",method = RequestMethod.POST)
    public Map addAnswer(@RequestBody JSONObject jsonObject,HttpSession session){
        Answer answer = new Answer();
        Teacher teacher = (Teacher) session.getAttribute("USER");
        answer.setQid(jsonObject.getLong("Qid"));
        answer.setTid(teacher.getTid());
        answer.setTname(teacher.getTname());
        answer.setAtext(jsonObject.getString("Atext"));
        answer.setAtime(simpleDateFormat.format(new Date()));
        answer.setAfile(false);
        System.out.println(answer.getQid()+"  "+answer.getTid()+"  "+answer.getTname()+answer.getAtext()+answer.getAtime()+answer.isAfile());
        answerImpl.insert(answer);
        Map result = new HashMap();
        result.put("result",1);
        return result;
    }

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile file,HttpSession session){
        String fileName = file.getOriginalFilename();
        int hashcode = simpleDateFormat.format(new Date()).hashCode();
        fileName = String.valueOf(hashcode)+fileName.substring(fileName.lastIndexOf('.'));
        String filePath = "src/main/resources/static/pic/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        Map param = new HashMap();
        Student student = (Student) session.getAttribute("USER");
        param.put("Sid",student.getSid());
        List<Question> QuestionList = questionImpl.searchQuestionList(param);
        questionImpl.uploadFile(QuestionList.get(0).getQid(),true,"/pic/"+fileName);
        return "上传成功!";
    }

    @RequestMapping(value = "/editFile",method = RequestMethod.POST)
    public String editFile(@RequestParam("file")MultipartFile file,@RequestParam("Qid") Long Qid){
        String fileName = file.getOriginalFilename();
        int hashcode = simpleDateFormat.format(new Date()).hashCode();
        fileName = String.valueOf(hashcode)+fileName.substring(fileName.lastIndexOf('.'));
        String filePath = "src/main/resources/static/pic/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        questionImpl.uploadFile(Qid,true,"/pic/"+fileName);
        return "上传成功!";
    }
}
