package ru.job4j.isp;

public class WrongISP3 {

    /*
    В Lamborgenni присуствует весь функционал, а вот в
    грузвовике отсвуствует часть функционала т.к она ему
    не нужна.
    Вывод создать еще 1 интерфейс который расширяет фунц. машины
     */
    interface WrongISP3Car {

        void wheel();
        void engine();
        void body();
        void transmission();
        void slidingRoof();
        void gpsPad();
    }

    class Lamborgenni implements WrongISP3Car {

        @Override
        public void wheel() {

        }

        @Override
        public void engine() {

        }

        @Override
        public void body() {

        }

        @Override
        public void transmission() {

        }

        @Override
        public void slidingRoof() {

        }

        @Override
        public void gpsPad() {

        }
    }

    class TruckKamaz implements WrongISP3Car {

        @Override
        public void wheel() {

        }

        @Override
        public void engine() {

        }

        @Override
        public void body() {

        }

        @Override
        public void transmission() {

        }

        @Override
        public void slidingRoof() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void gpsPad() {
            throw new UnsupportedOperationException();
        }
    }
}
