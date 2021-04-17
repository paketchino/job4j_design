package ru.job4j.it;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Test.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EventTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new Event(new int[] {1, 2, 3, 4, 5, 6, 7});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}