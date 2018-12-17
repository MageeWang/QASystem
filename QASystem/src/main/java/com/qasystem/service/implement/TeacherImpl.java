package com.qasystem.service.implement;

import com.qasystem.dao.TeacherMapper;
import com.qasystem.domain.Teacher;
import com.qasystem.service.TeacherService;
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
    public int update(Teacher teacher){
        return this.teacherMapper.update(teacher);
    }
    @Override
    public List<Teacher> getTeacherListByMid(Long Mid){
        return this.teacherMapper.getTeacherListByMid(Mid);
    }
}
