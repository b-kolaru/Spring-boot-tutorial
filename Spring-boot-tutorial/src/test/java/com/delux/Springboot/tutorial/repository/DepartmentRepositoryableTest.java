package com.delux.Springboot.tutorial.repository;

import com.delux.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryableTest {

    @Autowired
     private DepartmentRepositoryable departmentRepositoryable;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().deptName("Order Management")
                .deptAddress("Ottawa")
                .deptCode("ESD").build();
        entityManager.persist(department);
    }

    @Test
    public void retrieveDepartmentName_whenIDisCorrect(){
        Department department = departmentRepositoryable.findById(1L).get();
        assertEquals(department.getDeptName(),"Order Management");
    }
}