package ru.job4j.srp.solidexample;

import java.util.Objects;

public class Book {

    private String name;
    private String author;
    private int price;
    private int id;

    public Book(String name, String author, int price, int id) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return price == book.price && Objects.equals(name, book.name)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price);
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\''
                + ", author='" + author + '\''
                + ", price=" + price + '}';
    }
}
