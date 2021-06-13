package ru.job4j.io.output;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ArgsNameTest {

    @Test
    public void whenGetFirst() {
        ArgsName argsName = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        assertThat(argsName.getKey("Xmx"), is("512"));
    }
}