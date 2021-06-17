package ru.job4j.io.output;
import org.junit.Test;
//
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ArgsNameTest {

    @Test
    public void whenGetFirst() {
        ArgsName argsName = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        assertThat(argsName.getKey("Xmx"), is("512"));
    }

    @Test
    public void whenGetFirstReorder() {
        ArgsName argsName = ArgsName.of(new String[]{"-encoding=UTF-8", "-Xmx=512"});
        assertThat(argsName.getKey("Xmx"), is("512"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName argsName = ArgsName.of(new String[]{});
        argsName.getKey("Xmx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongSomeArguments() {
        ArgsName argsName = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx="});
    }
}