package ru.job4j.it.generic;

public class User<T extends Base> extends Base {
    protected User(String id) {
        super(id);
    }
}
