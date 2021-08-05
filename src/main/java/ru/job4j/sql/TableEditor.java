package ru.job4j.sql;

import org.postgresql.jdbc.PgConnection;
import ru.job4j.socket.EchoServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private final String URL_KEY = "con.url";
    private final String URL_LOGIN = "con.login";
    private final String URL_PASSWORD = "con.password";

    private Connection connection;

    private static Properties properties;

    public TableEditor(Properties properties) throws Exception {
        TableEditor.properties = properties;
        initConnection();
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            TableEditor.properties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                TableEditor.getValue(URL_KEY),
                TableEditor.getValue(URL_LOGIN),
                TableEditor.getValue(URL_PASSWORD)
        );
    }


    private void setConnection(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable (String tableName) {
        String sql = String.format("create table if not exist %s();", tableName);
        setConnection(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format("drop table if exists %s;", tableName);
        setConnection(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("alter table %s add %s %s;", tableName, columnName, type);
        setConnection(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("alter table %s drop column %s;", tableName, columnName);
        setConnection(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("alter table %s change '%s '%s;", tableName, columnName, newColumnName);
        setConnection(sql);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }
}
