package com.qasystem.service;

import com.qasystem.domain.Answer;

import java.util.List;

public interface AnswerService {
    int insert(Answer answer);
    int deleteByQid(Long Qid);
    int delete(Long Qid,Long Tid);
    int update(Answer answer);
    List<Answer> getAnswerListByQid(Long Qid);
    List<Answer> getAnswerListByTid(Long Tid);
}
