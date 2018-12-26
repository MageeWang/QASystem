package com.qasystem.service;

import com.qasystem.domain.Question;
import com.qasystem.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    int insert(Teacher teacher);
    int delete(Teacher teacher);
    int update(Long Tid,String Tname,String Tpsw,String Tinfo,String Tlevel);
    List<Teacher> getTeacherListByDid(Long Did);
    Teacher getTeacherByTid(Long Tid);
    List<Question> getUnAnsweredQuestionList(Long Tid);
}
