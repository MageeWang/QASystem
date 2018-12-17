package com.qasystem.service;

import com.qasystem.domain.Department;

import java.util.List;

public interface DeptService {
    int addNewDept(Department department);
    int updateDept(Long Did,String Dinfo);
    int deleteDept(Long Did);
    List<Department> queryDeptList();
}
