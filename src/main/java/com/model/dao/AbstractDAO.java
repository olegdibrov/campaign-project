package com.model.dao;

import com.model.entity.Entity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public  abstract class AbstractDAO <T extends Entity> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
    public abstract List<T> findAll();
    public abstract T findEntityById(int id);
    public abstract boolean delete(int id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }
}
