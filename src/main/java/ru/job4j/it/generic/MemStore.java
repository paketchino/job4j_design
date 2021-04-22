package ru.job4j.it.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    private int ids = 1;

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T t = findById(id);
        if (mem.set(t, model)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        T t = findById(id);
        return mem.remove(t);
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
