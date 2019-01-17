package com.service.interfaces;

import com.model.entity.University;

import java.util.List;

public interface IUniversityService {
    List<University> getAllUniversities();
    List<University> getUniversitiesBySpeciality(int id);
}
