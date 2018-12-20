package com.qasystem.dao;

import com.qasystem.domain.Answer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Mapper
public interface AnswerMapper {
    @Insert("insert into Answer values(#{Qid},#{Tid},#{Tname},#{Atext},#{Atime},#{Afile})")
    int insert(Answer answer);
    @Delete("delete from Answer where Qid=#{Qid}")
    int deleteByQid(Long Qid);
    @Delete("delete from Answer where Qid=#{Qid} and Tid=#{Tid}")
    int delete(Long Qid,Long Tid);
    @Update("update Answer set Atext=#{Atext},Atime=#{Atime},Afile=#{Afile} where Qid=#{Qid} and Tid=#{Tid}")
    int update(Answer answer);
    @Select("select * from Answer where Qid=#{Qid}")
    List<Answer> getAnswerListByQid(Long Qid);
    @Select("select * from Answer where Tid=#{Tid}")
    List<Answer> getAnswerListByTid(Long Tid);
}
