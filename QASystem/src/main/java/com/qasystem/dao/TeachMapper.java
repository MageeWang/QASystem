package com.qasystem.dao;

import com.qasystem.domain.Teach;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeachMapper {
    @Insert("insert into Teach values(#{Cid},#{Cname},#{Tid},#{Tname})")
    int insert(Teach teach);
    @Delete("delete from Teach where Cid=#{Cid} and Tid=#{Tid}")
    int delete(Teach teach);
    @Select("select * from Teach where Cid=#{Cid}")
    List<Teach> getCourseListByCid(Long Cid);
    @Select("select * from Teach where Tid=#{Tid}")
    List<Teach> getCourseListByTid(Long Tid);
}
