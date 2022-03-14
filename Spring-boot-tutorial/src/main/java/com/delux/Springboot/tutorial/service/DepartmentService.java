package com.delux.Springboot.tutorial.service;

import com.delux.Springboot.tutorial.entity.Department;
import com.delux.Springboot.tutorial.repository.DepartmentRepositoryable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceable{

    @Autowired
    private DepartmentRepositoryable repo;

    @Override
    public Department saveDepartment(Department department) {

        return repo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {

        return repo.findAll();
    }

    @Override
    public Department fetchDepartmentbyID(Long deptID) {
        return repo.findById(deptID).get();
    }

    @Override
    public void deleteDepartmentbyID(long deptID) {
        repo.deleteById(deptID);
    }

    @Override
    public Department updateDepartmentbyID(Long deptID, Department department) {
        Department departmentdb = repo.findById(deptID).get();

        if(Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())){
            departmentdb.setDeptName(department.getDeptName());
        }
        if(Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())){
            departmentdb.setDeptCode(department.getDeptCode());
        }
        if(Objects.nonNull(department.getDeptAddress()) && !"".equalsIgnoreCase(department.getDeptAddress())){
            departmentdb.setDeptAddress(department.getDeptAddress());
        }

        return repo.save(departmentdb);
    }

    @Override
    public Department fetchDepartmentbyName(String deptName) {
        return repo.findByDeptName(deptName);
    }


}
