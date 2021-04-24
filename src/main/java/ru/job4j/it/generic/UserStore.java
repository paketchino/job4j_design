package ru.job4j.it.generic;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        store.findById(id);
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        store.findById(id);
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }

    @Override
    public String toString() {
        return "UserStore{"
                + "store=" + store
                + '}';
    }
}
