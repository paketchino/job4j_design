package ru.job4j.ood.srp.solidexample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SrpEx implements Store {

    Connection cn;

    /*
    Данный метод, подсчитывает min и max числа в одном методе, что является ошибкой
    т.к пользователю может понадобиться найти одно из числе + метод отвечает еще и за вывод чисел,
    что тоже является нарушением spr. Данный метод отвечает сразу за 3 действия.
     */

    public static void methodSearchMinMax(int first, int second, int three, int forth) {
        int resultFirst = first > second ? first : second;
        int resultSecond = three > forth ? three : forth;
        int findMax = resultFirst > resultSecond ? resultFirst : resultSecond;
        int resultThird = first < second ? first : second;
        int resultForth = three < forth ? three : forth;
        int findMin = resultThird < resultForth ? resultThird : resultForth;
        System.out.println("Поиск максимального " + findMax + " числа"
                + " и минимального " + "числа " + findMin);
    }

    public static void main(String[] args) {
        methodSearchMinMax(1, 2, 3, 4);
    }


    /*
    Если клиенту необходимо выполнить что то одно либо.
    Добавить информацию в бд либо получает список всех созданных постов в БД
    Тут также проявляется связь с ISP
     */

    /**
     * добавляет в БД информацию о book
     * @param book на сайте
     */

    @Override
    public void save(Book book) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into post(name, author, price) values (?, ?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getName());
            statement.setInt(3, book.getPrice());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * получает список всех созданных постов в БД
     * @return bookList список постов в БД
     */
    @Override
    public List<Book> getALL() {
        List<Book> postList = new ArrayList<>();
        try (PreparedStatement prepared = cn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = prepared.executeQuery()) {
                while (resultSet.next()) {
                    postList.add(new Book(
                            resultSet.getString("name"),
                            resultSet.getString("author"),
                            resultSet.getInt("price"),
                            resultSet.getInt("id")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    class Product  {

        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Product product = (Product) o;
            return price == product.price && Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        /*
       Нельзя чтобы операции логики выполнялись непосредственно в классе
       где создаются обьекты. Для этого необходимо создавать отдельный интерфейс и реализовывать
       его в другом классе
         */

        public String findName(List<Book> storage, Book book) {
           String nameBook = null;
            for (Book value : storage) {
                if (value.equals(book.getName())) {
                    nameBook = book.getName();
                }
            }
            return nameBook;
        }
    }

}
