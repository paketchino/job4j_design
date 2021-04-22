package ru.job4j.it.generic;

public abstract class Base {

    private final String id;

    protected Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


}
