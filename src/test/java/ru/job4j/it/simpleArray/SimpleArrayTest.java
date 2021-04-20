package ru.job4j.it.simpleArray;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        int[] array = {1, 2, 3};
        SimpleArray<?> it = new SimpleArray<>(array);

    }
}