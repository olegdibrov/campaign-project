package com.model.dao.implementation;

import com.model.dao.AbstractDAO;
import com.model.entity.Role;
import com.model.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SQL_INSERT_USER = "INSERT INTO user (name, surname, email, password, role) VALUES(?,?,?,?,?)";
    private static final String SQL_FIND_USER = "SELECT * FROM user WHERE email=? AND password=?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT * FROM user WHERE email=?";

    private List<User> parseSet(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setRole(Role.valueOf(resultSet.getString(6).trim().toUpperCase()));
            users.add(user);
        }
        return users;
    }

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            return parseSet(resultSet);
        } catch (SQLException e) {
            LOGGER.error("Error statement user");
        }
        return null;
    }

    @Override
    public User findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getRole().name());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Error to insert data to db");
            return false;
        }
    }

    public User login(String email, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_FIND_USER);
            System.out.println(stmt);
            stmt.setString(1, email);
            stmt.setString(2, password);
            System.out.println(stmt);
            ResultSet resultSet = stmt.executeQuery();
            List<User> users = parseSet(resultSet);
            if (users.isEmpty())
                return null;
            else return  users.get(0);
        } catch (SQLException exp) {
            LOGGER.error("Error statement user");
        }
        return null;
    }

    public User findByEmail(String email) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_FIND_BY_EMAIL);
            stmt.setString(1, email);
            System.out.println(stmt);
            ResultSet resultSet = stmt.executeQuery();
            List<User> users = parseSet(resultSet);
            if (users.isEmpty())
                return null;
            else return  users.get(0);
        } catch (SQLException exp) {
            LOGGER.error("Error statement");
        }
        return null;
    }
}
