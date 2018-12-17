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
    @Insert("insert into Student values(#{Sid},#{Sname},#{Spsw},#{Did},#{Mid},#{Syear})")
    int insert(Student student);

    @Update("update Student set Sname=#{Sname},Spsw=#{Sname} where Sid = #{Sid}")
    int update(Student student);

    @Select("select * from Student where Sid = #{Sid}")
    @Results(id = "Student", value = {
            @Result(property = "Sid", column = "Sid", javaType = Long.class),
            @Result(property = "Sname", column = "Sname", javaType = String.class),
            @Result(property = "Spsw", column = "Spsw", javaType = String.class),
            @Result(property = "Did", column = "Did", javaType = Long.class),
            @Result(property = "Dname", column = "Dname", javaType = String.class),
            @Result(property = "Mid", column = "Mid", javaType = Long.class),
            @Result(property = "Mname", column = "Mname", javaType = String.class),
            @Result(property = "Syear", column = "Syear", javaType = String.class)
    })
    Student getStudentBySid(@Param("Sid") Long Sid);

    @SelectProvider(type = StudentSqlBuilder.class, method = "queryStudentByParams")
    List<Student> queryStudentList(Map<String, Object> params);

    class StudentSqlBuilder {
        public String queryStudentByParams(final Map<String, Object> params) {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from Student where 1=1");
            if (!StringUtil.isNull((String) params.get("Sname"))) {
                sql.append(" and Sname like '%").append((String) params.get("Sname")).append("%'");
            }
            if (!StringUtil.isNull((String) params.get("Sdept"))) {
                sql.append(" and Sdept like '%").append((String) params.get("Sdept")).append("%'");
            }
            System.out.println("查询sql==" + sql.toString());
            return sql.toString();
        }
    }
}
