package com.qasystem.service.implement;

import com.qasystem.dao.TeacherMapper;
import com.qasystem.domain.Teacher;
import com.qasystem.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public int insert(Teacher teacher){
        return this.teacherMapper.insert(teacher);
    }
    @Override
    public int delete(Teacher teacher){
        return this.teacherMapper.delete(teacher);
    }
    @Override
    public int update(Long Tid,String Tname,String Tpsw,String Tinfo,String Tlevel){
        return this.teacherMapper.update(Tid,Tname,Tpsw,Tinfo,Tlevel);
    }
    @Override
    public List<Teacher> getTeacherListByDid(Long Did){
        return this.teacherMapper.getTeacherListByDid(Did);
    }
    @Override
    public Teacher getTeacherByTid(Long Tid){
        return this.teacherMapper.getTeacherByTid(Tid);
    }
}
