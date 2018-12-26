package com.qasystem.service;

import com.qasystem.domain.Teach;

import java.util.List;

public interface TeachService {
    int insert(Teach teach);
    int delete(Teach teach);
    List<Teach> getCourseListByCid(Long Cid);
    List<Teach> getCourseListByTid(Long Tid);
    Teach getTeach(Teach teach);
}
