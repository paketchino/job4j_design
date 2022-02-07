package ru.job4j.clone;

public class ShallowClone {

    static class Pig {

        private String name;

        public Pig(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Pig{" + "name='"
                    + name + '\'' + '}';
        }
    }

    static class Animal implements Cloneable {

        private String name;

        private Pig pig;

        public Animal(String name, Pig pig) {
            this.name = name;
            this.pig = pig;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Pig getPig() {
            return pig;
        }

        public void setPig(Pig pig) {
            this.pig = pig;
        }

        @Override
        public String toString() {
            return "Animal{"
                    + "name='" + name
                    + '\'' + ", pig="
                    + pig + '}';
        }

        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        Pig pig = new Pig("Свинка пепа");
        Pig pig1 = new Pig("Not pig");
        Animal animalOriginal = new Animal("Животное", pig);
        Animal animalClone = null;
        try {
            animalClone = (Animal) animalOriginal.clone();
            animalClone.setPig(pig1);
            System.out.println(animalOriginal);
            System.out.println(animalClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
