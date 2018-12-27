package com.model.dao.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionMySQL {
    private static volatile DataSource dataSource;
    private static Logger logger =  LogManager.getLogger(ConnectionMySQL.class);

    private ConnectionMySQL() {
    }

    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionMySQL.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ResourceBundle resource = ResourceBundle.getBundle("database");
                    ds.setDriverClassName(resource.getString("driver"));
                    ds.setUrl(resource.getString("url"));
                    ds.setUsername(resource.getString("user"));
                    ds.setPassword(resource.getString("password"));
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}
