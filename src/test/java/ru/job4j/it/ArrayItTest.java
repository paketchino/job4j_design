package ru.job4j.it;
//
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayItTest {

    @Test
    public void whenMultiCallHasNextThenTrue() {
        ArrayIt it = new ArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        ArrayIt it = new ArrayIt(
                new int[] {}
        );
        it.next();
    }
}