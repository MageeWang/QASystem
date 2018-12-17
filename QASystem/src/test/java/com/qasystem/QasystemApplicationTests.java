package com.qasystem;

import com.qasystem.dao.TeacherMapper;
import com.qasystem.domain.Course;
import com.qasystem.domain.Teacher;
import com.qasystem.service.implement.CourseImpl;
import com.qasystem.service.implement.TeacherImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QasystemApplicationTests {
    @Autowired
    private CourseImpl courseImpl;
    @Test
    @Rollback
    public void contextLoads() {
        Course course = new Course();
        course.setCid(11111000L);
        course.setCname("aaa");
        course.setCinfo("aaa");
        course.setMid(1208L);
        course.setMname("aaa");
        course.setDid(12L);
        course.setDname("aaa");
        courseImpl.insert(course);
        courseImpl.update(course);
        System.out.println(courseImpl.getCourseListByMid(1208L).get(0).getCname());
        courseImpl.delete(course);
    }
}
