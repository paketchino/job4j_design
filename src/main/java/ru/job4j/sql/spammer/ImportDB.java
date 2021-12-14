package ru.job4j.sql.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.BinaryOperator;
import java.sql.Statement;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(dump))) {
            String read;
            while ((read = bf.readLine()) != null) {
                if (read.isEmpty()) {
                    continue;
                }
                String[] lines = read.split(";");
                users.add(new User(lines[0], lines[1]));
                }
            }
         return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password"))) {
            for (User user : users) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement("insert into users1 (person, email) values (?, ?)")) {
                    preparedStatement.setString(1, user.getPerson());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.execute();
                }
            }
        }
    }

    private class User {


        private String person;
        private String email;

        public User(String person, String email) {
            this.person = person;
            this.email = email;
        }

        public String getPerson() {
            return person;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties cfg = new Properties();
        ClassLoader loader = ImportDB.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("config.properties")) {
            cfg.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImportDB importDB = new ImportDB(cfg, "C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\sql\\spammer\\dump.txt");
        importDB.save(importDB.load());
    }
}
