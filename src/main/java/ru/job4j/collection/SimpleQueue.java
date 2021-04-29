package ru.job4j.collection;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<T>();
    private final SimpleStack<T> out = new SimpleStack<T>();


    public T poll() {
        return null;
    }

    public void push(T value) {

    }
}
