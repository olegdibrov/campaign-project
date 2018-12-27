package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Department;
import com.model.entity.Speciality;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAO extends AbstractDAO<Speciality> {
    private static final Logger LOGGER = Logger.getLogger(SpecialityDAO.class);

    private static final String SQL_SELECT_ALL_SPECIALITY = "SELECT * FROM speciality";
    private static final String SQL_INSERT_SPECIALITY = "INSERT INTO speciality (idSpeciality, specialityName) VALUES(?,?)";

    public SpecialityDAO(Connection connection) {
        super(connection);
    }


    @Override
    public boolean delete(Speciality entity) {
        return false;
    }

    @Override
    public void close(Statement st) {
        super.close(st);
    }

    private List<Speciality> parseSet(ResultSet resultSet) throws SQLException {
        List<Speciality> specialities = new ArrayList<>();
        while (resultSet.next()) {
            Speciality speciality = new Speciality();
            speciality.setIdSpeciality(resultSet.getInt(1));
            speciality.setSpecialityName(resultSet.getString(2));
            specialities.add(speciality);
        }
        return specialities;
    }


    @Override
    public List<Speciality> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SPECIALITY);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;
    }

    @Override
    public Speciality findEntityById(int id) {
        return null;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public boolean create(Speciality entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_SPECIALITY);
            stmt.setInt(1, entity.getIdSpeciality());
            stmt.setString(2, entity.getSpecialityName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Some exception while working with database");
            return false;
        }
        return true;
    }

}
