package ru.job4j.ood.isp.wrongisp;

public class WrongISP1 implements WriteWongISP1, CallWrongISP1, MessengerWrong1ISP {

    /*
    Допустим нам необходимо создать мессенджер, который может звонить
    создавать и отправлять сообщение. Было создано 3 разных интерфейса и в
    данной ситуации абстракция была определенна не правильно т.к
    данные функции могут вызываться из одного или двух интерфейсов в зависимости
    от следующих реализации
     */


    @Override
    public void call() {

    }

    @Override
    public void createContact() {

    }

    @Override
    public void write() {

    }
}
