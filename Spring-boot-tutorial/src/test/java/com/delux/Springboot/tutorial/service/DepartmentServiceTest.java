package com.delux.Springboot.tutorial.service;

import com.delux.Springboot.tutorial.entity.Department;
import com.delux.Springboot.tutorial.repository.DepartmentRepositoryable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepositoryable departmentRepositoryable;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().deptID(1L)
                .deptCode("LNP")
                .deptAddress("Ottawa")
                .deptName("Porting").build();
        Mockito.when(departmentRepositoryable.findByDeptName("Porting")).thenReturn(department);
    }

    @Test
    @DisplayName("Testing Service layer for department name")
    public void whenDepartmentNameisValid_thenDepartmentShouldbeFound(){
        String departName = "Porting";
        Department found = departmentService.fetchDepartmentbyName(departName);
        assertEquals(departName,found.getDeptName(), "Porting");

    }
}