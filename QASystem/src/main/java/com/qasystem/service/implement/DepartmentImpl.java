package com.qasystem.service.implement;

import com.qasystem.dao.DepartmentMapper;
import com.qasystem.domain.Department;
import com.qasystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DeptService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public int insert(Department department){
        return this.departmentMapper.insert(department);
    }
    @Override
    public int delete(Department department){
        return this.departmentMapper.delete(department);
    }
    @Override
    public int update(Department department){
        return this.departmentMapper.update(department);
    }
    @Override
    public List<Department> getDeptList(){
        return this.departmentMapper.getDeptList();
    }
    @Override
    public Department getDeptByDid(Long Did){
        return this.departmentMapper.getDeptByDid(Did);
    }
}
