package ru.job4j.iterator;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ListUtilsTest {

    @Test
    public void addBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void addAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 2, 4);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(input));
    }

    @Test
    public void removeIfNeedCheckValue() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeIf(input, index -> index.intValue() < 2);
        assertThat(Arrays.asList(2, 3), Is.is(input));
    }

    @Test
    public void removeIfNeedCheckValue2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(input, index -> index.intValue() < 4);
        assertThat(Arrays.asList(4, 5), Is.is(input));
    }

    @Test
    public void replaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.replaceIf(input, integer -> integer.intValue() > 2, 2);
        assertThat(Arrays.asList(1, 2, 2, 2, 2), Is.is(input));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeAll(input, output);
        assertThat(input, Is.is(Arrays.asList(5)));
    }
}