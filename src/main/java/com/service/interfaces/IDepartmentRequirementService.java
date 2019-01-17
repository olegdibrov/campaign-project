package com.service.interfaces;

import com.model.entity.DepartmentRequirements;
import com.model.entity.Subject;

import java.util.List;

public interface IDepartmentRequirementService {
    List<DepartmentRequirements> getAllDepartments();
    List<Subject> getSubjectsByDepartment(int idDepartment);
}
