package com.qasystem.service;

import com.qasystem.domain.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerService {
    int insert(Answer answer);
    int deleteByQid(Long Qid);
    int delete(Long Qid,Long Tid);
    int update(Long Qid,Long Tid,String Atext,String Atime);
    List<Answer> getAnswerListByQid(Long Qid);
    List<Answer> getAnswerListByTid(Long Tid);
    Answer getAnswer(Long Qid,Long Tid);
}
