package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.DepartmentDAO;
import com.model.entity.Department;
import com.model.entity.Speciality;
import com.service.interfaces.IDepartmentService;
import org.apache.log4j.Logger;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final static Logger LOGGER = Logger.getLogger(AuthenticationService.class);

    private DepartmentDAO departmentDAO;

    DepartmentService(DaoFactory daoFactory) {
        departmentDAO = daoFactory.getDepartmentDao();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    @Override
    public List<Department> getAllDistinctDepartments() {
        return departmentDAO.findAllDistinct();
    }

    @Override
    public List<Department> getUniversitiesByParameters(int idSpeciality, int idUniversity) {
        return departmentDAO.getUniversitiesByParameters(idSpeciality, idUniversity);
    }
}
