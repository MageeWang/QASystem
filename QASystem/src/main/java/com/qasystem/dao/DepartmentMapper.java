package com.qasystem.dao;

import com.qasystem.domain.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Mapper
public interface DepartmentMapper {
    @Insert("insert into Department values(#{Did},#{Dname},#{Dinfo})")
    int insert(Department department);
    @Delete("delete from Department where Did = #{Did}")
    int delete(Department department);
    @Update("update Department set Dname = #{Dname},Dinfo = #{Dinfo} where Did = #{Did}")
    int update(Department department);
    @Select("select * from Department")
    List<Department> getDeptList();
    @Select("select * from Department where Did=#{Did}")
    Department getDeptByDid(Long Did);
}
