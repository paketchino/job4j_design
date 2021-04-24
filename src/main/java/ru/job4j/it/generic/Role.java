package ru.job4j.it.generic;

public class Role<T extends Base> extends Base {
    protected Role(String id) {
        super(id);
    }
}
