package ru.job4j.it.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        boolean rsl = index != 1;
        if (rsl) {
            mem.set(index, model);
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        boolean rsl = index != 1;
        if (rsl) {
            mem.remove(index);
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        return index != -1 ? mem.get(index) : null;
    }

    private int findIndexById(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
