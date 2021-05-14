package ru.job4j.collection.hash;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashTest {


    @Test
    public void insert() {
        SimpleHash<Integer, Integer> hash = new SimpleHash<>(3);
        assertTrue(hash.insert(1, 1));
    }
}