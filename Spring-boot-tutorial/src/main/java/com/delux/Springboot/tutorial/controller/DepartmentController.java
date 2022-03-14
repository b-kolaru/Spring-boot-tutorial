package com.delux.Springboot.tutorial.controller;

import com.delux.Springboot.tutorial.entity.Department;
import com.delux.Springboot.tutorial.service.DepartmentServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentServiceable departmentServiceable;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside save department of Department controller");
        return departmentServiceable.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentServiceable.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentbyID(@PathVariable("id") Long deptID){
        return departmentServiceable.fetchDepartmentbyID(deptID);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentbyID(@PathVariable("id") long deptID){
        departmentServiceable.deleteDepartmentbyID(deptID);
        return "Department Deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentbyID(@PathVariable("id") Long deptID, @RequestBody Department department){
        return departmentServiceable.updateDepartmentbyID(deptID, department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentbyName(@PathVariable("name") String deptName){
        return departmentServiceable.fetchDepartmentbyName(deptName);

    }
}
