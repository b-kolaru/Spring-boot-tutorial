package com.delux.Springboot.tutorial.repository;

import com.delux.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryable extends JpaRepository<Department, Long> {

    Department findByDeptName(String deptName);

    Department findByDeptNameIgnoreCase(String deptName);
}
