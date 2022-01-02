package ru.job4j.ocp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class WrongOPC3 {

    /*
    Подобный подход мешает наследованию
    хоть оно и не всегда применимо
     */

    public void load(Properties properties) {
        Connection cn;
        try (var loader = WrongOPC3.class.getClassLoader().getResourceAsStream("app.properties")) {
            Class.forName(properties.getProperty("jdbc.driver"));
            cn = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
