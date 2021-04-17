package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixItTest {

    @Test
    public void whenRowHasDiffSize() {
        MatrixIt it = new MatrixIt(
                new int[][] {{1, 2}, {3, 4, 5}}
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
    }

    @Test
    public void when4() {
        MatrixIt it = new MatrixIt(
                new int[][] {{1, 2, 3}, {4, 5, 6}}
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test
    public void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        it.next();
    }

    @Test
    public void whenNoElements() {
        int[][] in = {{}, {}, {}};
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenMultiHashNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
}