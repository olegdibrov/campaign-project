package com.model.dao.factory;

import com.model.dao.connection.ConnectionMySQL;
import com.model.dao.implementation.*;
import org.apache.log4j.Logger;

import java.sql.Connection;

public class DaoFactory {
    private final static Logger LOGGER = Logger.getLogger(DaoFactory.class);

    private static DaoFactory instance;
    private UserDAO userDao;
    private UniversityDAO universityDao;
    private DepartmentDAO departmentDao;
    private DepartmentRequirementsDAO departmentRequirementsDAO;
    private SpecialityDAO specialityDAO;
    private ExamDAO examDAO;
    private RatingDAO ratingDAO;
    private SubjectDAO subjectDAO;

    private Connection connection = ConnectionMySQL.getConnection();

    private DaoFactory() {
        userDao = new UserDAO(connection);
        universityDao = new UniversityDAO(connection);
        departmentDao = new DepartmentDAO(connection);
        specialityDAO = new SpecialityDAO(connection);
        departmentRequirementsDAO = new DepartmentRequirementsDAO(connection);
        examDAO = new ExamDAO(connection);
        ratingDAO = new RatingDAO(connection);
        subjectDAO = new SubjectDAO(connection);
    }

    private static void init(){
        instance = new DaoFactory();
    }

    public static DaoFactory getInstance() {
        if(instance == null) {
            LOGGER.debug("Default init from ConnectionMySQL");
            init();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public UniversityDAO getUniversityDao() {
        return universityDao;
    }

    public DepartmentDAO getDepartmentDao() {
        return departmentDao;
    }

    public SpecialityDAO getSpecialityDAO() {
        return specialityDAO;
    }

    public DepartmentRequirementsDAO getDepartmentRequirementsDAO() {
        return departmentRequirementsDAO;
    }

    public ExamDAO getExamDAO() {
        return examDAO;
    }

    public RatingDAO getRatingDAO() {
        return ratingDAO;
    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }
}
