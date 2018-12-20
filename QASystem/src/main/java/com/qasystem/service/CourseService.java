package com.qasystem.service;

import com.qasystem.domain.Course;

import java.util.List;

public interface CourseService {
    int insert(Course course);
    int delete(Course course);
    int update(Course course);
    List<Course> getCourseListByDid(Long Did);
    Course getCourseByCid(Long Cid);
}
