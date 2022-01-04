package ru.job4j.lsd.product;

import java.time.LocalDate;
import java.util.Objects;

public class Food {

    private String name;

    private LocalDate expiryDate;

    private LocalDate createDate;

    private double price;

    private int discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setPriceAfterDiscount() {
        price = price - (price / 100 * discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && discount == food.discount
                && Objects.equals(name, food.name)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{" + "name='"
                + name + '\'' + ", expiryDate=" + expiryDate
                + ", createDate="
                + createDate + ", price="
                + price + ", discount="
                + discount + '}';
    }
}
