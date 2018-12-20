package com.qasystem.service;

import com.qasystem.domain.Department;

import java.util.List;

public interface DeptService {
    int insert(Department department);
    int delete(Department department);
    int update(Department department);
    List<Department> getDeptList();
    Department getDeptByDid(Long Did);
}
