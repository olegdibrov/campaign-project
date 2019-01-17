package com.service.interfaces;

import com.model.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    List<Department> getAllDistinctDepartments();
    List<Department> getUniversitiesByParameters(int idSpeciality, int idUniversity);
}
