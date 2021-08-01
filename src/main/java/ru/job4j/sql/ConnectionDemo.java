package ru.job4j.sql;

import ru.job4j.io.output.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    private static Config config = new Config("app.properties");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        config.load();
        String url = config.value("connection.url=jdbc:postgresql://localhost:5432/idea_db");
        String login = config.value("connection.user=postgres");
        String password = config.value("connection.password=password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
