package com.example.springbatch.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfig {
    private final DataSource dataSource;

    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct // used for initialization tasks. These tasks are typically related to setting up resources, establishing connections, or performing any necessary setup operations for the bean.
    public void initializeDatabase() {
        executeScript("schema-drop-mysql.sql");
        executeScript("schema-mysql.sql");
    }

    private void executeScript(String scriptName) {
        try {
            ScriptUtils.executeSqlScript(dataSource.getConnection(),
                    new ClassPathResource(scriptName));
        } catch (Exception e) {
            // Handle exceptions if necessary
            e.printStackTrace();
        }
    }

    }
