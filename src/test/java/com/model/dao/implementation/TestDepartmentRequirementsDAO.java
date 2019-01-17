package com.model.dao.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Department;
import com.model.entity.DepartmentRequirements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDepartmentRequirementsDAO {
    private DepartmentRequirements testDepartment;
    private DepartmentRequirementsDAO departmentDAO;


    @BeforeEach
    void init() {
        testDepartment = new DepartmentRequirements();
        testDepartment.setIdDepartmentRequirements(1);
        testDepartment.setIdDepartment(1);
        testDepartment.setIdSubject(2);
        departmentDAO = DaoFactory.getInstance().getDepartmentRequirementsDAO();
    }

    @Test
    void testCreate() {
        departmentDAO.create(testDepartment);
        DepartmentRequirements resultDepartment = departmentDAO.findEntityById(testDepartment.getIdDepartmentRequirements());
        Assertions.assertEquals(testDepartment, resultDepartment);
    }

    @Test
    void testFindAll() {
        List<DepartmentRequirements> departments = departmentDAO.findAll();
        Assertions.assertFalse(departments.size() < 1);
    }


}
