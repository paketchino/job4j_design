package ru.job4j.ood.isp.wrongisp;

import java.util.Iterator;

public interface Traversable<T> {

    Iterator<T> preOrder();
    Iterator<T> inOrder();
    Iterator<T> postOrder();

    Iterator<T> bfs();
    Iterator<T> dfs();

}
