package com.qasystem.service.implement;

import com.qasystem.dao.AnswerMapper;
import com.qasystem.domain.Answer;
import com.qasystem.service.AnswerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public int insert(Answer answer){
        return this.answerMapper.insert(answer.getQid(),answer.getTid(),answer.getTname(), answer.getAtext(), answer.getAtime(), answer.isAfile());
    }
    @Override
    public int deleteByQid(Long Qid){
        return this.answerMapper.deleteByQid(Qid);
    }
    @Override
    public int delete(Long Qid,Long Tid){
        return this.answerMapper.delete(Qid,Tid);
    }
    @Override
    public int update(Long Qid,Long Tid,String Atext,String Atime){
        return this.answerMapper.update(Qid,Tid,Atext,Atime);
    }
    @Override
    public List<Answer> getAnswerListByQid(Long Qid){
        return this.answerMapper.getAnswerListByQid(Qid);
    }
    @Override
    public List<Answer> getAnswerListByTid(Long Tid){
        return this.answerMapper.getAnswerListByTid(Tid);
    }
    @Override
    public Answer getAnswer(Long Qid,Long Tid){
        return this.answerMapper.getAnswer(Qid,Tid);
    }
}
