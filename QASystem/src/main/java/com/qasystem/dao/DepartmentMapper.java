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
    int addNewDept(Department department);
    @Update("update Department set Dinfo = #{Dinfo} where Did = #{DId}")
    int updateDept(Long Did,String Dinfo);
    @Delete("delete from Department where Did = #{Did}")
    int deleteDept(Long Did);
    @Select("select * from Department")
    List<Department> queryDeptList();
}
