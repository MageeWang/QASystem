package com.qasystem.service.implement;

import com.qasystem.dao.QuestionMapper;
import com.qasystem.domain.Question;
import com.qasystem.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public int insert(Question question) {
        return this.questionMapper.insert(question);
    }
    @Override
    public int delete(Long Qid) {
        return this.questionMapper.delete(Qid);
    }
    @Override
    public int updateQuestion(Long Qid, String Qtitle, String Qtext, String Qtime, boolean Qfile) {
        return this.questionMapper.updateQuestion(Qid, Qtitle, Qtext, Qtime, Qfile);
    }
    @Override
    public int updateUnread(Long Qid,Integer Qunread) {
        return this.questionMapper.updateUnread(Qid,Qunread);
    }
    @Override
    public int uploadFile(Long Qid,boolean Qfile,String Qhref){
        return this.questionMapper.uploadFile(Qid,Qfile,Qhref);
    }
    @Override
    public List<Question> searchQuestionList(Map<String, Object> param) {
        return this.questionMapper.searchQuestionList(param);
    }
    @Override
    public Question getQuestion(Long Qid) {
        return this.questionMapper.getQuestion(Qid);
    }
}
