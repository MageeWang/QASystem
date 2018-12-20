package com.qasystem.service.implement;

import com.qasystem.dao.TeachMapper;
import com.qasystem.domain.Teach;
import com.qasystem.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachImpl implements TeachService {
    @Autowired
    private TeachMapper teachMapper;
    @Override
    public int insert(Teach teach){
        return this.teachMapper.insert(teach);
    }
    @Override
    public int delete(Teach teach){
        return this.teachMapper.delete(teach);
    }
    @Override
    public List<Teach> getCourseListByCid(Long Cid){
        return this.teachMapper.getCourseListByCid(Cid);
    }
    @Override
    public List<Teach> getCourseListByTid(Long Tid){
        return this.teachMapper.getCourseListByTid(Tid);
    }
}
