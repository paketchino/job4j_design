package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> findParent = findBy(parent);
        Optional<Node<E>> findChild = findBy(child);
        if (!findChild.isPresent() && findParent.isPresent()) {
            Node<E> newNode = new Node<>(child);
            findParent.get().children.add(newNode);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean isBinary() {
        return findByPredicate((ch) -> ch.children.size() > 2).isPresent();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate((val) -> val.value.equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
