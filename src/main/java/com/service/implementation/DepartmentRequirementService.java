package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.DepartmentRequirementsDAO;
import com.model.dao.implementation.ExamDAO;
import com.model.dao.implementation.SubjectDAO;
import com.model.dao.implementation.UserDAO;
import com.model.entity.DepartmentRequirements;
import com.model.entity.Exam;
import com.model.entity.ExamPreview;
import com.model.entity.Subject;
import com.service.interfaces.IDepartmentRequirementService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRequirementService implements IDepartmentRequirementService {
    private final static Logger LOGGER = Logger.getLogger(DepartmentRequirementService.class);

    private DepartmentRequirementsDAO departmentRequirementsDAO;
    private SubjectDAO subjectDAO;

    DepartmentRequirementService(DaoFactory daoFactory) {
        departmentRequirementsDAO = daoFactory.getDepartmentRequirementsDAO();
        subjectDAO = daoFactory.getSubjectDAO();
    }

    @Override
    public List<DepartmentRequirements> getAllDepartments() {
        return departmentRequirementsDAO.findAll();
    }

    @Override
    public List<Subject> getSubjectsByDepartment(int idDepartment) {
        List<Subject> subjects = new ArrayList<>();
        System.out.println("id department: " + idDepartment);
        List<DepartmentRequirements> departmentRequirements = departmentRequirementsDAO.findRequirementsForDepartment(idDepartment);
        for (DepartmentRequirements departmentRequirement : departmentRequirements) {
            System.out.println("department - " + departmentRequirement.getIdDepartment());
            Subject subject = subjectDAO.findEntityById(departmentRequirement.getIdSubject());
            subjects.add(subject);
        }
        if (subjects.size() == 0) {
            System.out.println("no subjects");
        }
        return subjects;
    }
}
