package ru.job4j.sql;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class TableEditorTest {

    Properties properties = new Properties();

    @Test
    public void whenNeedFindFileProperties() throws Exception {
        TableEditor tableEditor = new TableEditor(properties);
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream file = loader.getResourceAsStream("connection.properties")) {
            tableEditor.load(file);
        }
        tableEditor.initConnection();
        String url = TableEditor.getValue("con.url");
        String login = TableEditor.getValue("con.login");
        String password = TableEditor.getValue("con.password");
        assertThat(url, is("jdbc:postgresql://localhost:5432/idea_db"));
        assertThat(login, is("postgres"));
        assertThat(password, is("streetZ1"));
    }
}