package com.qasystem.dao;

import com.qasystem.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeacherMapper {
    @Insert("insert into Teacher values(#{Tid},#{Tname},#{Tpsw},#{Did},#{Dname},#{Mid},#{Mname},#{Tinfo},#{Tlevel})")
    int insert(Teacher teacher);
    @Delete("delete from Teacher where Tid=#{Tid}")
    int delete(Teacher teacher);
    @Update("update Teacher set Tname=#{Tname},Tpsw=#{Tpsw},Did=#{Did},Dname=#{Dname},Mid=#{Mid},Mname=#{Mname},Tinfo=#{Tinfo},Tlevel=#{Tlevel} where Tid=#{Tid}")
    int update(Teacher teacher);
    @Select("select * from Teacher where Mid=#{Mid}")
    List<Teacher> getTeacherListByMid(Long Mid);
}
