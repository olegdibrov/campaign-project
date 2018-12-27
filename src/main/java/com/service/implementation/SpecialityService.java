package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Speciality;

import java.util.List;

public class SpecialityService {
    private DaoFactory daoFactory;

    public SpecialityService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Speciality> getAllSpecialities() {
        return daoFactory.getSpecialityDAO().findAll();
    }
}
