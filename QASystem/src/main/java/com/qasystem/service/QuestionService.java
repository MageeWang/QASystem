package com.qasystem.service;

import com.qasystem.dao.QuestionMapper;
import com.qasystem.domain.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    int insert(Question question);
    int delete(Long Qid);
    int updateQuestion(@Param("Qid") Long Qid, @Param("Qtitle") String Qtitle, @Param("Qtext") String Qtext, @Param("Qtime") String Qtime, @Param("Qfile") boolean Qfile);
    int updateUnread(@Param("Qid") Long Qid,@Param("Qunread") Integer Qunread);
    List<Question> searchQuestionList(Map<String,Object> param);
    Question getQuestion(Long Qid);
}
