package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.SpecialityDAO;
import com.model.entity.Speciality;
import com.service.interfaces.ISpecialityService;

import java.util.List;

public class SpecialityService implements ISpecialityService {
    private SpecialityDAO specialityDAO;

    SpecialityService(DaoFactory daoFactory) {
        specialityDAO = daoFactory.getSpecialityDAO();
    }

    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityDAO.findAll();
    }
}
