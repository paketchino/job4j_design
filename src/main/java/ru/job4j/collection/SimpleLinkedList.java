package ru.job4j.collection;

import java.util.*;
import java.util.function.Predicate;
import java.util.LinkedList;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount;

    public SimpleLinkedList () {
        last = new Node<E>(null, first, null);
        first = new Node<>(null, null, last);
    }

    @Override
    public void add(E value) {
        Node<E> prev = last;
        prev.setCurrentElement(value);
        last = new Node<E>(null, prev, null);
        prev.setNext(last);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.currentElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            final int expectedModCount = modCount;
            Node<E> current = first.next;

            @Override
            public boolean hasNext() {
                return current != last;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E index = current.currentElement;
                current = current.next;

                return index;
            }
        };
    }

    private class Node<E> {

         E currentElement;
         Node<E> next;
         Node<E> prev;

        private Node(E currentElement, Node <E> prev, Node<E> next) {
            this.currentElement = currentElement;
            this.next = next;
            this.prev = prev;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
}
