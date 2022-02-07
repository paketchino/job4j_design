package ru.job4j.ood.dip;

import ru.job4j.Hash;
import ru.job4j.it.generic.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryShopStore implements ShopStore {

    private HashMap<User, Set<Order>> tempStorage = new HashMap<>();

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean saveOrder(User user, Order order) {
        Set<Order> orders = tempStorage.getOrDefault(user, Set.of());
        if (orders.isEmpty()) {
            return false;
        }
        return orders.add(order);
    }

    @Override
    public Set<Order> getOrders(User user) {
        return tempStorage.get(user);
    }

    @Override
    public Set<User> getUsers() {
        return tempStorage.keySet();
    }
}
