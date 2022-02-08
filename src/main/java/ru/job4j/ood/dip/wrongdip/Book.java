package ru.job4j.ood.dip.wrongdip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Book {

    /*
  1. Данный метод нарушает DIP и SRP т.к в классе с обьектом создан
  метод для добавления и поиска
  Нужно создать интерфейс с методом add и реализовывыть его в отдельном классе
  сделав зависимость от ShelfImpl
  2. В классе так же присуствует хранилище, в данной ситуации мы зависим от реализации,
  а не от абстракции.
  3. Присуствует зависимость вывода от реализации т.к оно напрямую зависит от консольного вывода.

   */
    private List<Book> tempStorage = new ArrayList<>();

    public void add(Book book) {
        if (tempStorage.contains(book)) {
            System.out.println("Данная книга уже была добавлена");
            throw new IllegalArgumentException();
        } else {
            tempStorage.add(book);
        }
    }

    public Optional<Book> findBookByName(Book book) {
        return tempStorage
                .stream()
                .filter(b -> b.getName().equals(book.getName()))
                .findFirst();
    }

    public Optional<Book> findByYear(Book book) {
        return tempStorage
                .stream()
                .filter(b -> b.getYear() == book.getYear())
                .findFirst();
    }

    private String name;

    private int year;

    public Book(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
