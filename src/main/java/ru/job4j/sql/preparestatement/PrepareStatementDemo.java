package ru.job4j.sql.preparestatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDemo {

    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "streetZ1";
        connection = DriverManager.getConnection(url, login, password);
    }

    private void insert1(City city) {
        try (PreparedStatement statement  =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement ps = connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            ps.setString(1, city.getName());
            ps.setInt(2, city.getPopulation());
            ps.setInt(3, city.getId());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(City city) {
        boolean result = false;
        try (PreparedStatement ps = connection.prepareStatement("delete from cities where id = ?;")) {
            ps.setInt(1, city.getId());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select distinct * from cities;")) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public City insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo demo = new PrepareStatementDemo();
        City city1 = new City(1, "Moscow", 10000);
        demo.insert(city1);
        City city2 = new City(2, "Penza", 256);
        demo.insert(city2);
        List<City> findAll = demo.findAll();
        for (City c : findAll) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getPopulation());
        }
        List<City> findAll2 = demo.findAll();
        System.out.println(demo.update(city1));
        demo.delete(city1);
        System.out.println(demo.update(city1));
    }
}
