package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.University;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO extends AbstractDAO<University> {
    private static final Logger LOGGER = Logger.getLogger(UniversityDAO.class);
    private static final String SQL_SELECT_ALL_UNIVERSITIES = "SELECT * FROM university";
    private static final String SQL_SELECT_UNIVERSITY_BY_ENTITY = "SELECT * FROM university where idUniversity = ?";

    public UniversityDAO(Connection connection) {
        super(connection);
    }

    private List<University> parseSet(ResultSet resultSet) throws SQLException {
        List<University> universities = new ArrayList<>();
        while (resultSet.next()) {
            University university = new University();
            university.setIdUniversity(resultSet.getInt(1));
            university.setUniversityName(resultSet.getString(2));
            universities.add(university);
        }
        return universities;
    }

    @Override
    public List<University> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_UNIVERSITIES);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Error statement universities");
        }
        return null;
    }

    @Override
    public University findEntityById(int id) {
        University university = new University();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_UNIVERSITY_BY_ENTITY);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                university.setIdUniversity(resultSet.getInt(1));
                university.setUniversityName(resultSet.getString(2));
            }

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return university;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(University entity) {
        return false;
    }

    @Override
    public boolean create(University entity) {
        return false;
    }

    @Override
    public void close(Statement st) {
        super.close(st);
    }
}
