package com.model.dao.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDepartmentDAO {
    private Department testDepartment;
    private DepartmentDAO departmentDAO;


    @BeforeEach
    void init() {
        testDepartment = new Department();
        testDepartment.setIdDepartment(1);
        testDepartment.setDepartmentName("TestDepartment");
        testDepartment.setIdSpeciality(1);
        testDepartment.setIdDepartment(1);
        testDepartment.setNumberOfFreeSpace(1);
        departmentDAO = DaoFactory.getInstance().getDepartmentDao();
    }

    @Test
    void testCreate() {
        departmentDAO.create(testDepartment);
        Department resultDepartment = departmentDAO.findEntityById(testDepartment.getIdDepartment());
        Assertions.assertEquals(testDepartment, resultDepartment);
    }

    @Test
    void testFindAll() {
        List<Department> departments = departmentDAO.findAll();
        Assertions.assertFalse(departments.size() <= 1);
    }

}
