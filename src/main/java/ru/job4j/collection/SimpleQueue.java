package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<T>();
    private final SimpleStack<T> out = new SimpleStack<T>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
