package com.nodir.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    private static final String configPath = "src/main/resources/sql.properties";

    static {
        config = new HikariConfig(configPath);
        dataSource = new HikariDataSource(config);
    }

    public DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
