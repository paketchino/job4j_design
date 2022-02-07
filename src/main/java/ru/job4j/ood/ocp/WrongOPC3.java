package ru.job4j.ood.ocp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WrongOPC3 {

    /*
    Данный метод возвращаете List, что
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
    Метод возвращает ArrayList, чтобы не нарушить
    OCP должны возвращать интерфейс List<Integer>
     */
    public ArrayList<Integer> getSum(int a, int b) {
        System.out.println("Something doing");
        return null;
    }
}
