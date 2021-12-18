package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class MaxMin {

    public <T> T getValue(List<T> list, Comparator<T> comparator, Predicate<Integer> condition) {
        T value = list.get(0);
        for (int i = 1; i < list.size(); i++) {
           int resultCompare = comparator.compare(value, list.get(i));
           if (condition.test(resultCompare)) {
               value = list.get(i);
           }
        }
        return value;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, max -> max <= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, min -> min >= 0);
    }
}
