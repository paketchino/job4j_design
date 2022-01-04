package ru.job4j.lsd.product;

import java.time.LocalDate;

public class Sugar extends Food {

    public Sugar(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }

}
