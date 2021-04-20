package ru.job4j.it.simpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<T> {

    private T[] values;
    private int index = 0;
    private int size;

    public SimpleArray(T[] values) {
        this.values = values;
    }

    public void add(T model) {
        Objects.checkIndex(index, size);
        values[size] = model;
        size++;
    }


    public void remove(int index) {

    }


    public void set(Object o, int index) {

    }


    public Object get() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public T next() {
        return values[index++];
    }
}
