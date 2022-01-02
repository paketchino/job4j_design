package ru.job4j.ocp;

public class WrongOCP2 {

    /*
    Собака не кошка, но тоже издает звуки. Если
    будут внесены какие то изменения в класс Dog,
    то класс Cat нужно будет изменять.
    В данной ситуации необходимо создать интерфейс
    voice()
     */

    static class Dog {
        String text;

        public Dog(String text) {
            this.text = text;
        }

        public void voice() {
            System.out.println("Gav-gav");
        }
    }

    static class Cat extends Dog {
        public Cat(String text) {
            super(text);
        }

        public void voice() {
            System.out.println("Mya-Mya");
        }
    }

}
