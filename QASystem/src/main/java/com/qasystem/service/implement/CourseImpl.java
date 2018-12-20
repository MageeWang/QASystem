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
    @Override
    public int insert(Course course){
        return this.courseMapper.insert(course);
    }
    @Override
    public int delete(Course course){
        return this.courseMapper.delete(course);
    }
    @Override
    public int update(Course course){
        return this.courseMapper.update(course);
    }
    @Override
    public List<Course> getCourseListByDid(Long Did){
        return this.courseMapper.getCourseListByDid(Did);
    }
    @Override
    public Course getCourseByCid(Long Cid){
        return this.courseMapper.getCourseByCid(Cid);
    }
}
