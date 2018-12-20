package com.qasystem.service;

import com.qasystem.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int insert(Student student);
    int update(Student student);
    Student getStudentBySid(@Param("Sid") Long Sid);
}
