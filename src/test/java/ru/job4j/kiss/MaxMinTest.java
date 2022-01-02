package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void max() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        MaxMin maxMin = new MaxMin(list, comparator);
        assertThat(maxMin.max(list, comparator), is(3));
    }

    @Test
    public void min() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        MaxMin maxMin = new MaxMin(list, comparator);
        assertThat(maxMin.min(list, comparator), is(1));
    }
}