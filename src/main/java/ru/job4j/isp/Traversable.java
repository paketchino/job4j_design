package ru.job4j.isp;

import java.util.Iterator;

public interface Traversable<T> {

    Iterator<T> preOrder();
    Iterator<T> inOrder();
    Iterator<T> postOrder();

    Iterator<T> bfs();
    Iterator<T> dfs();

}
