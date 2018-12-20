package com.qasystem.dao;

import com.qasystem.domain.Student;
import com.qasystem.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface StudentMapper {
    @Insert("insert into Student values(#{Sid},#{Sname},#{Spsw},#{Did},#{Dname},#{Syear})")
    int insert(Student student);

    @Update("update Student set Sname=#{Sname},Spsw=#{Spsw} where Sid = #{Sid}")
    int update(Student student);

    @Select("select * from Student where Sid = #{Sid}")
    @Results(id = "Student", value = {
            @Result(property = "Sid", column = "Sid", javaType = Long.class),
            @Result(property = "Sname", column = "Sname", javaType = String.class),
            @Result(property = "Spsw", column = "Spsw", javaType = String.class),
            @Result(property = "Did", column = "Did", javaType = Long.class),
            @Result(property = "Dname", column = "Dname", javaType = String.class),
            @Result(property = "Syear", column = "Syear", javaType = String.class)
    })
    Student getStudentBySid(@Param("Sid") Long Sid);

}
