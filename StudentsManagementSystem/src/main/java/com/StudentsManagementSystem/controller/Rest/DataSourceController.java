package com.StudentsManagementSystem.controller.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DataSourceController {

    private final DataSource dataSource;

    public DataSourceController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/check-datasource")
    public String checkDataSource() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            return "URL: " + conn.getMetaData().getURL() +
                   " | Driver: " + conn.getMetaData().getDriverName();
        }
    }
}
