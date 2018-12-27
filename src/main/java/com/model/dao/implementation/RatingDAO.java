package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Department;
import com.model.entity.Entity;
import com.model.entity.Rating;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO extends AbstractDAO<Rating> {
    private static final Logger LOGGER = Logger.getLogger(DepartmentDAO.class);

    private static final String SQL_SELECT_ALL_RATING = "SELECT * FROM rating";
    private static final String SQL_INSERT_RATING = "INSERT INTO rating (idUser, department_idDepartment, rating) VALUES(?,?,?)";
    private static final String SQL_FIND_RATING_BY_ID_USER = "SELECT * FROM department WHERE idUser=?";

    private List<Rating> parseSet(ResultSet resultSet) throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        while (resultSet.next()) {
            Rating rating = new Rating();
            rating.setIdRating(resultSet.getInt(1));
            rating.setIdUser(resultSet.getInt(2));
            rating.setIdDepartment(resultSet.getInt(3));
            rating.setRating(resultSet.getInt(4));
            ratings.add(rating);
        }
        return ratings;
    }

    public RatingDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_RATING);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;    }

    @Override
    public Rating findEntityById(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_FIND_RATING_BY_ID_USER);
            System.out.println(stmt);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            List<Rating> ratings = parseSet(resultSet);
            if (ratings.isEmpty())
                return null;
            else return  ratings.get(0);
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
    public boolean delete(Rating entity) {
        return false;
    }

    @Override
    public boolean create(Rating entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_RATING);
            stmt.setInt(1, entity.getIdUser());
            stmt.setInt(2, entity.getIdDepartment());
            stmt.setInt(3, entity.getRating());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
            return false;
        }
        return true;
    }

    @Override
    public void close(Statement st) {
        super.close(st);
    }
}
