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
    public int addNewDept(Department department) {
        return this.departmentMapper.addNewDept(department);
    }

    @Override
    public int updateDept(Long Did, String Dinfo) {
        return this.departmentMapper.updateDept(Did,Dinfo);
    }

    @Override
    public int deleteDept(Long Did) {
        return this.departmentMapper.deleteDept(Did);
    }

    @Override
    public List<Department> queryDeptList() {
        return this.departmentMapper.queryDeptList();
    }
}
