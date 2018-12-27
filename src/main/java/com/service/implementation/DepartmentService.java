package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Department;
import com.model.entity.Speciality;
import org.apache.log4j.Logger;

import java.util.List;

public class DepartmentService {
    private final static Logger LOGGER = Logger.getLogger(AuthenticationService.class);

    private DaoFactory daoFactory;

    public DepartmentService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Department> getAllDepartments() {
        return daoFactory.getDepartmentDao().findAll();
    }
}
