package ru.job4j.collection.hash;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHash<K, V> implements Iterable {
    Node<K, V>[] item;
    int size;
    int modCount;

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
        if ((double)(size / item.length) >= 0.75) {
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

    private int increase() {
        SimpleHash<K, V> newItem = new SimpleHash<>(item.length * 2);
        return 0;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = findIndexInTheBucket(hash);
        Objects.checkIndex(index, item.length);
        return (V) item[index];
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
    public Iterator iterator() {
        return new Iterator() {

            private int exceptedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (exceptedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return item[index++].value;
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
