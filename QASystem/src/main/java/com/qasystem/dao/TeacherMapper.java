package com.qasystem.dao;

import com.qasystem.domain.Question;
import com.qasystem.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper
public interface TeacherMapper {
    @Insert("insert into Teacher values(#{Tid},#{Tname},#{Tpsw},#{Did},#{Dname},#{Tinfo},#{Tlevel})")
    int insert(Teacher teacher);
    @Delete("delete from Teacher where Tid=#{Tid}")
    int delete(Teacher teacher);
    @Update("update Teacher set Tname=#{Tname},Tpsw=#{Tpsw},Tinfo=#{Tinfo},Tlevel=#{Tlevel} where Tid=#{Tid}")
    int update(@Param("Tid") Long Tid,@Param("Tname") String Tname,@Param("Tpsw") String Tpsw,@Param("Tinfo") String Tinfo,@Param("Tlevel")String Tlevel);
    @Select("select * from Teacher where Did=#{Did}")
    List<Teacher> getTeacherListByDid(Long Did);
    @Select("select * from Teacher where Tid=#{Tid}")
    Teacher getTeacherByTid(Long Tid);
    @Select("select * from Question where Cid in (select Cid from Teach where Tid=#{Tid}) and Qid not in (select Qid from Answer where Tid=#{Tid})")
    List<Question> getUnAnsweredQuestionList(Long Tid);
}
