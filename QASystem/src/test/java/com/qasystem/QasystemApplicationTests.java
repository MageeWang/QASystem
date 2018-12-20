package com.qasystem;

import com.qasystem.dao.TeacherMapper;
import com.qasystem.domain.*;
import com.qasystem.service.implement.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QasystemApplicationTests {
    @Autowired
    private AnswerImpl answerImpl;
    @Test
    @Transactional
    public void contextLoads() {
        Answer answer = new Answer();
        answer.setQid(1L);
        answer.setTid(12002L);
        answer.setTname("ttttt");
        answer.setAtext("aaaaa");
        answer.setAtime("2018-12-20 10:43");
        answer.setAfile(false);
        answerImpl.insert(answer);
        System.out.println(answerImpl.getAnswerListByQid(1L).get(1).getTname());
        answer.setTname("zzzzz");
        answer.setAtext("zzzzz");
        answerImpl.update(answer);
        System.out.println(answerImpl.getAnswerListByQid(1L).get(1).getTname());
        answerImpl.deleteByQid(12002L);
    }
}
