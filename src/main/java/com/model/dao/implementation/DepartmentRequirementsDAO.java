package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Department;
import com.model.entity.DepartmentRequirements;
import com.model.entity.University;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRequirementsDAO extends AbstractDAO<DepartmentRequirements> {
    private static final Logger LOGGER = Logger.getLogger(ExamDAO.class);

    private static final String SQL_SELECT_ALL_DEPARTMENT_REQUIREMENTS = "SELECT * FROM department_requirements";
    private static final String SQL_INSERT_DEPARTMENT_REQUIREMENTS = "INSERT INTO department_requirements (idDepartment, idSubject) VALUES(?,?)";
    public static final String SQL_SELECT_REQUIREMENTS_FOR_DEPARTMENT = "SELECT * from department_requirements WHERE idDepartment = ?";

    public DepartmentRequirementsDAO(Connection connection) {
        super(connection);
    }

    private List<DepartmentRequirements> parseSet(ResultSet resultSet) throws SQLException {
        List<DepartmentRequirements> departmentRequirements = new ArrayList<>();
        while (resultSet.next()) {
            DepartmentRequirements department = new DepartmentRequirements();
            department.setIdDepartmentRequirements(resultSet.getInt(1));
            department.setIdDepartment(resultSet.getInt(2));
            department.setIdSubject(resultSet.getInt(3));
            departmentRequirements.add(department);
        }
        return departmentRequirements;
    }

    @Override
    public List<DepartmentRequirements> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_DEPARTMENT_REQUIREMENTS);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;
    }

    public List<DepartmentRequirements> findRequirementsForDepartment(int idDepartment) {
        List<DepartmentRequirements> departmentRequirements = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_REQUIREMENTS_FOR_DEPARTMENT);
            stmt.setInt(1, idDepartment);
            ResultSet resultSet = stmt.executeQuery();
            return parseSet(resultSet);
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
            return null;
        }
    }



    @Override
    public DepartmentRequirements findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(DepartmentRequirements entity) {
        return false;
    }

    @Override
    public boolean create(DepartmentRequirements entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_DEPARTMENT_REQUIREMENTS);
            stmt.setInt(1, entity.getIdDepartment());
            stmt.setInt(2, entity.getIdSubject());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
            return false;
        }
        return true;    }

    @Override
    public void close(Statement st) {
        super.close(st);
    }
}
