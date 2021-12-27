package ru.job4j.srp.solidexample;

import java.util.List;

public interface Store {

    void save(Book t);

    List<Book> getALL();
}
