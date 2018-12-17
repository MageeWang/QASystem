package com.qasystem.dao;

import com.qasystem.domain.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CourseMapper {
    @Insert("insert into Course values(#{Cid},#{Cname},#{Cinfo},#{Mid},#{Mname},#{Did},#{Dname})")
    int insert(Course course);
    @Delete("delete from Course where Cid=#{Cid}")
    int delete(Course course);
    @Update("update Course set Cname=#{Cname},Cinfo=#{Cinfo},Mid=#{Mid},Mname=#{Mname},Did=#{Did},Dname=#{Dname} where Cid=#{Cid}")
    int update(Course course);
    @Select("select * from Course where Mid=#{Mid}")
    List<Course> getCourseListByMid(Long Mid);
}
