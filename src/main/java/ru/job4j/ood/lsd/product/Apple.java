package ru.job4j.ood.lsd.product;

import java.time.LocalDate;

public class Apple extends Food {

    public Apple(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
