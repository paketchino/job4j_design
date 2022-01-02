package ru.job4j.ocp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class WrongOPC3 {

    /*
    Данный метод возвращаете null, что
    является не правильным т.к метод ничего не возвращает
     */

    public List load(Properties properties) {
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
        return null;
    }

    /*
    Метод принимает два параметра никак их не использует
    и ничего не возвращет
     */
    public void getSum(int a, int b) {
        System.out.println("Something doing");
    }
}
