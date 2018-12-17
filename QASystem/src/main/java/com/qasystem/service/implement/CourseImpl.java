package com.qasystem.service.implement;

import com.qasystem.dao.CourseMapper;
import com.qasystem.domain.Course;
import com.qasystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public int insert(Course course){
        return this.courseMapper.insert(course);
    }
    public int delete(Course course){
        return this.courseMapper.delete(course);
    }
    public int update(Course course){
        return this.courseMapper.update(course);
    }
    public List<Course> getCourseListByMid(Long Mid){
        return this.courseMapper.getCourseListByMid(Mid);
    }
}
