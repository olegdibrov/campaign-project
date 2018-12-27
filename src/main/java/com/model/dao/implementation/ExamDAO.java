package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Department;
import com.model.entity.Exam;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO extends AbstractDAO<Exam> {
    private static final Logger LOGGER = Logger.getLogger(ExamDAO.class);

    private static final String SQL_SELECT_ALL_EXAM = "SELECT * FROM exam";
    private static final String SQL_INSERT_EXAM = "INSERT INTO exam (idUser, idSubject) VALUES(?,?)";

    public ExamDAO(Connection connection) {
        super(connection);
    }

    private List<Exam> parseSet(ResultSet resultSet) throws SQLException {
        List<Exam> exams = new ArrayList<>();
        while (resultSet.next()) {
            Exam exam = new Exam();
            exam.setIdExam(resultSet.getInt(1));
            exam.setIdUser(resultSet.getInt(2));
            exam.setIdSubject(resultSet.getInt(3));
            exam.setMark(resultSet.getInt(4));
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public List<Exam> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_EXAM);
            return parseSet(resultSet);
        } catch (SQLException exp) {
            LOGGER.error("Some exception while working with database");
        }
        return null;
    }

    @Override
    public Exam findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Exam entity) {
        return false;
    }

    @Override
    public boolean create(Exam entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        try{
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_EXAM);
            stmt.setInt(1, entity.getIdUser());
            stmt.setInt(2, entity.getIdSubject());
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
