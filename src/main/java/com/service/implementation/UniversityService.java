package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.University;
import org.apache.log4j.Logger;

import java.util.List;

public class UniversityService {
    private final static Logger LOGGER = Logger.getLogger(UniversityService.class);

    private DaoFactory daoFactory;

    public UniversityService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<University> getAllUniversities(){
        return daoFactory.getUniversityDao().findAll();
    }

    public List<University> getUniversitiesBySpeciality(int id) {
        List<University> universities = daoFactory.getDepartmentDao().getUniversitiesBySpeciality(id);
        if (universities.isEmpty()) {
            LOGGER.error("no universities in such speciality");
        }
        else {
            for (University university: universities ) {
                 university = daoFactory.getUniversityDao().findEntityById(university.getIdUniversity());
            }
        }
        return universities;
    }

}
