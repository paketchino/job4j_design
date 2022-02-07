package ru.job4j.ood.isp.wrongisp;

public class EmailWrongISP2 implements WrongISP2 {

    /*
    В данной ситуации мы создаем емаил на подобие gmail, mail etc
    и реализация метода call становится не нужной т.к в них отсуствует
    такой функционал чтобы реализовать емаил придется заглушать метод
     */

    @Override
    public void call() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createContact() {

    }

    @Override
    public void sendMessage() {

    }
}
