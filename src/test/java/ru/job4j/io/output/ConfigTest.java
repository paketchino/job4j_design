package ru.job4j.io.output;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "test.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test
    public void whenFileWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is(Matchers.nullValue()));
        assertThat(config.value("hibernate.connection.url"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairOutOfOrder() {
        String path = "./data/pair_out_of_order.properties";
        Config config = new Config(path);
        config.load();
    }
}