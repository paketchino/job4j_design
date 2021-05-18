package ru.job4j.collection;
//
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public int size() {
        return size;
    }

    public boolean revert() {
        boolean rsl = false;
        Node reversePart = null;
        Node current = head;
        if ( current.next == null) {
            return false;
        }
        while (current != null) {
            Node next = current.next;
            current.next = reversePart;
            reversePart = current;
            current = next;
            rsl = true;
            }
        head = reversePart;
        return rsl;
    }

    public T deleteFirst() {
        T element = null;
        if (head == null) {
            throw new NoSuchElementException();
        }
        element = head.value;
        head = head.next;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
