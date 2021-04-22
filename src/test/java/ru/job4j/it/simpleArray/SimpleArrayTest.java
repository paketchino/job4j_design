package ru.job4j.it.simpleArray;

import org.junit.Test;

import javax.swing.*;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void addNewElement() {
        SimpleArray<String> list = new SimpleArray(10);
        list.add("Petya");
        list.add("Alexey");
        list.add("Sasha");
        assertThat(list.get(0), is("Petya"));
        assertThat(list.get(1), is("Alexey"));
        assertThat(list.get(2), is("Sasha"));
    }

    @Test
    public void whenSetNewElement() {
        SimpleArray<String> list = new SimpleArray<>(3);
        list.add("Petya");
        list.add("Alexey");
        list.set("Roman", 0);
        assertThat(list.get(0), is("Roman"));
    }

    @Test
    public void whenNeedGetNewElement() {
        SimpleArray<String> list = new SimpleArray<>(3);
        list.add("Petya");
        assertThat(list.get(0), is("Petya"));
    }

    @Test
    public void whenRemoveNewElement() {
        SimpleArray<String> list = new SimpleArray<>(5);
        list.add("Petya");
        list.add("Alexey");
        list.add("Maksim");
        list.add("Stas");
        list.remove((0));
        assertThat(list.get(0), is("Alexey"));
    }

    @Test
    public void whenNeedCheckIterator() {
        SimpleArray<String> list = new SimpleArray<>(3);
        list.add("Petya");
        list.add("Alexey");
        list.add("Maksim");
        Iterator<String> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Petya"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Alexey"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Maksim"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetException() {
        SimpleArray<String> list = new SimpleArray<>(3);
        list.add("Petya");
        list.add("Alexey");
        list.get(2);
    }
}