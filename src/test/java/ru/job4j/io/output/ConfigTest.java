package ru.job4j.io.output;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

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