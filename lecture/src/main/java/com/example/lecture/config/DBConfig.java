package com.example.lecture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false"
        );
        dataSource.setUsername("bitai");
        dataSource.setPassword("456123");

        return dataSource;
    }
}
