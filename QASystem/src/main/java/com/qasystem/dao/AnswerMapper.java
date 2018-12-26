package com.qasystem.dao;

import com.qasystem.domain.Answer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Mapper
public interface AnswerMapper {
    @Insert("insert into Answer values(#{Qid},#{Tid},#{Tname},#{Atext},#{Atime},#{Afile},'')")
    int insert(@Param("Qid")Long Qid,@Param("Tid")Long Tid,@Param("Tname")String Tname,@Param("Atext")String Atext,@Param("Atime")String Atime,@Param("Afile")boolean Afile);
    @Delete("delete from Answer where Qid=#{Qid}")
    int deleteByQid(Long Qid);
    @Delete("delete from Answer where Qid=#{Qid} and Tid=#{Tid}")
    int delete(@Param("Qid") Long Qid,@Param("Tid") Long Tid);
    @Update("update Answer set Atext=#{Atext},Atime=#{Atime} where Qid=#{Qid} and Tid=#{Tid}")
    int update(@Param("Qid") Long Qid,@Param("Tid") Long Tid,@Param("Atext") String Atext,@Param("Atime") String Atime);
    @Select("select * from Answer where Qid=#{Qid}")
    List<Answer> getAnswerListByQid(Long Qid);
    @Select("select * from Answer where Tid=#{Tid}")
    List<Answer> getAnswerListByTid(Long Tid);
    @Select("select * from Answer where Qid=#{Qid} and Tid=#{Tid}")
    Answer getAnswer(@Param("Qid") Long Qid,@Param("Tid") Long Tid);
}
