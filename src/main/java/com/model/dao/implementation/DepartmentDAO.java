package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Department;
import com.model.entity.University;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends AbstractDAO<Department> {
    private static final Logger LOGGER = Logger.getLogger(DepartmentDAO.class);

    private static final String SQL_SELECT_ALL_DEPARTMENT = "SELECT * FROM department";
    private static final String SQL_INSERT_DEPARTMENT = "INSERT INTO department (idSpeciality, idUniversity, numberOfFreeSpace) VALUES(?,?,?)";
    private static final String SQL_FIND_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE idDepartment=?";
    private static final String SQL_UNIVERSITIES_BY_SPECIALITY = "SELECT DISTINCT idUniversity from department WHERE idSpeciality = ?";

    public DepartmentDAO(Connection connection) {
        super(connection);
    }

    private List<Department> parseSet(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department();
            department.setIdDepartment(resultSet.getInt(1));
            department.setIdSpeciality(resultSet.getInt(2));
            department.setIdUniversity(resultSet.getInt(3));
            department.setNumberOfFreeSpace(resultSet.getInt(4));
            departments.add(department);
        }
        return departments;
    }

    @Override
    public List<Department> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_DEPARTMENT);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;
    }

    @Override
    public Department findEntityById(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_FIND_DEPARTMENT_BY_ID);
            System.out.println(stmt);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            List<Department> profiles = parseSet(resultSet);
            if (profiles.isEmpty())
                return null;
            else return  profiles.get(0);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Department entity) {
        return false;
    }

    @Override
    public boolean create(Department entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_DEPARTMENT);
            stmt.setInt(1, entity.getIdSpeciality());
            stmt.setInt(2, entity.getIdUniversity());
            stmt.setInt(3, entity.getNumberOfFreeSpace());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
            return false;
        }
        return true;
    }

    public List<University> getUniversitiesBySpeciality(int idSpeciality) {
        List<University> universities = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_UNIVERSITIES_BY_SPECIALITY);
            stmt.setInt(1, idSpeciality);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                University university = new University();
                university.setIdUniversity(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
        }
        return universities;

    }


}