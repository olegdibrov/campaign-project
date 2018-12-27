package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Subject;
import com.model.entity.University;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends AbstractDAO<Subject> {
    private static final Logger LOGGER = Logger.getLogger(SubjectDAO.class);

    private static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM subject";
    private static final String SQL_INSERT_SUBJECT = "INSERT INTO subject (subjectName) VALUES(?)";

    public SubjectDAO(Connection connection) {
        super(connection);
    }

    private List<Subject> parseSet(ResultSet resultSet) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()) {
            Subject subject = new Subject();
            subject.setIdSubject(resultSet.getInt(1));
            subject.setSubjectName(resultSet.getString(2));
            subjects.add(subject);
        }
        return subjects;
    }

    @Override
    public List<Subject> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBJECTS);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;    }

    @Override
    public Subject findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Subject entity) {
        return false;
    }

    @Override
    public boolean create(Subject entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_SUBJECT);
            stmt.setString(1, entity.getSubjectName());
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
