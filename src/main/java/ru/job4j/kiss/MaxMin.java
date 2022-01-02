package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.List;

public class MaxMin<T> {

    private List<T> list;
    private Comparator<T> comparator;

    public MaxMin(List<T> list, Comparator<T> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    private T getValue(List<T> list, Comparator<T> comparator, Predicate<Integer> condition) {
        T value = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int resultCompare = comparator.compare(value, list.get(i));
            if (condition.test(resultCompare)) {
                value = list.get(i);
            }
        }
        return value;
    }

    public T max(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, max -> max < 0);
    }

    public T min(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, min -> min > 0);
    }
}
