package ru.job4j.collection.hash;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashTest {

    @Test
    public void WhenInsert() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        hash.insert(1, "Roman");
        hash.insert(2, "Evgen");
        assertThat(hash.get(1), is("Roman"));
    }

    @Test
    public void whenNeedCheckIterator() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        hash.insert(1, "Roman");
        hash.insert(2, "Evgen");
        Iterator<Integer> it = hash.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenNeedCheckDelete() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        hash.insert(1, "Roman");
        hash.insert(2, "Evgen");
        assertTrue(hash.delete(1));
        assertTrue(hash.delete(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenNeedCheckConcurrentModificationException() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        hash.insert(1, "Roman");
        Iterator<Integer> it = hash.iterator();
        hash.insert(2, "Evgen");
        it.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNeedCheckNull() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        Iterator<Integer> it = hash.iterator();
        it.next();
    }

    @Test
    public void whenNeedToCheckIncrease() {
        SimpleHash<Integer, String> hash = new SimpleHash<>(3);
        hash.insert(1, "Roman");
        hash.insert(2, "Evgen");
        hash.insert(3, "Serega");
        hash.insert(4, "Petr");
        hash.insert(5, "Stas");
    }
}