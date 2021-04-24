package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int modCount;
    private Object[] container;
    private int size;

    public SimpleArray(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (container.length == size) {
            Object[] newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, size);
            container = newContainer;
        }
        container[size] = model;
        size++;
        modCount++;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removeElement = (T) container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        size--;
        modCount++;
        return removeElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {

        private int expectedModCount = modCount;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) container[index++];
        }
    }
}
