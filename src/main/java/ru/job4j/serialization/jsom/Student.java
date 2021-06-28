package ru.job4j.serialization.jsom;

public class Student {
    private final int age;
    private final String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "age="
                + age + ", name='"
                + name + '\'' + '}';
    }
}
