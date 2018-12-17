package com.qasystem.service;

import com.qasystem.domain.Teacher;

import java.util.List;

public interface TeacherService {
    int insert(Teacher teacher);
    int delete(Teacher teacher);
    int update(Teacher teacher);
    List<Teacher> getTeacherListByMid(Long Mid);
}
