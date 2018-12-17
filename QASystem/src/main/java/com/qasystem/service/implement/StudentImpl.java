package com.qasystem.service.implement;

import com.github.pagehelper.PageHelper;
import com.qasystem.dao.StudentMapper;
import com.qasystem.domain.Student;
import com.qasystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insert(Student student){
        return this.studentMapper.insert(student);
    }
    @Override
    public int update(Student student){
        return this.studentMapper.update(student);
    }
    @Override
    public Student getStudentBySid(Long Sid){
        return this.studentMapper.getStudentBySid(Sid);
    }
    @Override
    public List<Student> queryStudentList(Map<String,Object> param){
        PageHelper.startPage(Integer.parseInt(param.get("page").toString()),Integer.parseInt(param.get("rows").toString()));
        return this.studentMapper.queryStudentList(param);
    }
}
