package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("first");
        String rsl = strings.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("first");
        String rsl = strings.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmply() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("first");
        strings.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("first");
        Iterator<String> iterator = strings.iterator();
        strings.add("second");
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveCorruptedIt() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("first");
        strings.add("second");
        Iterator<String> iterator = strings.iterator();
        strings.remove(1);
        iterator.next();
    }

    @Test
    public void whenNeedEnlarge() {
        SimpleArray<String> strings = new SimpleArray<>(2);
        strings.add("first");
        strings.add("second");
        strings.add("first");
        strings.add("second");
        assertThat(strings.get(0), is("first"));
        assertThat(strings.get(1), is("second"));
        assertThat(strings.get(2), is("first"));
        assertThat(strings.get(3), is("second"));
    }
}