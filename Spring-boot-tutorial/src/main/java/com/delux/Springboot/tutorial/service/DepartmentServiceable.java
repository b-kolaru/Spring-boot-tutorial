package com.delux.Springboot.tutorial.service;

import com.delux.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentServiceable {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentbyID(Long deptID);

    void deleteDepartmentbyID(long deptID);

    Department updateDepartmentbyID(Long deptID, Department department);

    Department fetchDepartmentbyName(String deptName);
}
