package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.DepartmentRequirements;
import org.apache.log4j.Logger;

import java.util.List;

public class DepartmentRequirementService {
    private final static Logger LOGGER = Logger.getLogger(DepartmentRequirementService.class);

    private DaoFactory daoFactory;

    public DepartmentRequirementService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<DepartmentRequirements> getAllDepartments() {
        return daoFactory.getDepartmentRequirementsDAO().findAll();
    }
}
