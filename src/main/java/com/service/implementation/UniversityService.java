package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.DepartmentDAO;
import com.model.dao.implementation.UniversityDAO;
import com.model.entity.University;
import com.service.interfaces.IUniversityService;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UniversityService implements IUniversityService {
    private final static Logger LOGGER = Logger.getLogger(UniversityService.class);

    private UniversityDAO universityDAO;
    private DepartmentDAO departmentDAO;

    UniversityService(DaoFactory daoFactory) {
        universityDAO = daoFactory.getUniversityDao();
        departmentDAO = daoFactory.getDepartmentDao();
    }

    @Override
    public List<University> getAllUniversities(){
        return universityDAO.findAll();
    }

    @Override
    public List<University> getUniversitiesBySpeciality(int id) {
        List<University> universities = departmentDAO.getUniversitiesBySpeciality(id);
        if (universities.isEmpty()) {
            LOGGER.error("no universities in such speciality");
        }
        else {
            ListIterator<University> listIterator = universities.listIterator();
            while (listIterator.hasNext()) {
                University university = listIterator.next();
                listIterator.set(universityDAO.findEntityById(university.getIdUniversity()));
            }
        }
        return universities;
    }


}
