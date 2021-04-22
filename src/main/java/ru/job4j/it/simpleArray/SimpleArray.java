package ru.job4j.it.simpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private T[] values;
    private int index = 0;
    private int size;

    public SimpleArray(int capacity) {
        this.values = (T[]) new Object[capacity] ;
    }

    public void add(T model) {
        resizeIfNeed();
        values[size] = model;
        size++;
    }

    private void resizeIfNeed() {
        if (values.length == size) {
            Object[] newArray = new Object[values.length * 2];
            System.arraycopy(values, 0, newArray, 0, size);
            values = (T[]) newArray;
        }
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removeElement = values[index];
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        return removeElement;
    }

    public void set(T model, int index) {
        Objects.checkIndex(index, size);
        values[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return values[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public T next() {
                return values[index++];
            }
        };
    }
}
