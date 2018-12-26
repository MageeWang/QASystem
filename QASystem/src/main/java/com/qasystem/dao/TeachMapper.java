package com.qasystem.dao;

import com.qasystem.domain.Teach;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from Teach where Cid=#{Cid} and Tid=#{Tid}")
    Teach getTeach(@Param("Cid") Long Cid,@Param("Tid") Long Tid);
}
