package ru.job4j.collection.hash;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHash<K, V> implements Iterable<K> {
    private static final double LOAD_FACTOR = 0.75;
        private Node<K, V>[] item;
    private int size;
    private int modCount;
    private int capacity;

    public SimpleHash(int capacity) {
        this.item = new Node[capacity];
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int findIndexInTheBucket(int hash) {
        return hash & (item.length - 1);
    }

    public boolean insert(K key, V value) {
        if ((double)(size / item.length) >= LOAD_FACTOR) {
            increase();
        }
        int hash = hash(key);
        int index = findIndexInTheBucket(hash);
        Node<K, V> newNode = new Node<>(index, key, value);
        if (item[index] == null) {
            item[index] = newNode;
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    private void increase() {
        Node<K, V>[] newItem = new Node[item.length * 2];
        for (Node<K, V> node : item) {
            newItem[node.key.hashCode()] = node;
        }
        item = newItem;
    }

    public V get(K key)  {
        int hash = hash(key);
        int index = findIndexInTheBucket(hash);
        if (item[index] != null) {
            if (item[index].key.equals(key)) {
                return (V) item[index].value;
            }
        }
        return null;
    }

    public boolean delete(K key) {
        int hash = hash(key);
        int index = findIndexInTheBucket(hash);
        if (item[index] != null) {
            if (item[index].key.equals(key)) {
                item[index] = null;
                size--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator() {

            private int exceptedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                for (int i = index; i < item.length; i++) {
                    if (item[i] != null) {
                        index = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (exceptedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return item[index++].key;
            }
        };
    }

    private class Node<K, V> {
        int hash;
        K key;
        V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
