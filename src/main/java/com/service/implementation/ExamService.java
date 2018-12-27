package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.entity.Department;
import com.model.entity.Exam;
import org.apache.log4j.Logger;

import java.util.List;

public class ExamService {
    private final static Logger LOGGER = Logger.getLogger(ExamService.class);

    private DaoFactory daoFactory;

    public ExamService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Exam> getAllDepartments() {
        return daoFactory.getExamDAO().findAll();
    }
}
