package ru.job4j.sql;

import javax.swing.table.TableCellEditor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties  = properties;
        getConnection();
    }

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgres://localhost:5432/idea_db";
        String login = "postgres";
        String password = "streetZ1";
        return DriverManager.getConnection(properties.getProperty(url),
                properties.getProperty(login),
                properties.getProperty(password));
    }

    private void setConnection (String sql) {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable (String tableName) {
        String sql = String.format(
                "create table if not exist %s();", tableName);
        setConnection(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format("drop table exist %s();", tableName);
        setConnection(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("after table %s add %s %s();", tableName, columnName, type);
        setConnection(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("after table %s drop column %s();", tableName, columnName);
        setConnection(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("sp_rename '%s', '%s', '%s',;", tableName, columnName, newColumnName);
        setConnection(sql);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
