package ru.job4j.serialization.jsom;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {
    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    Student() {}

    @Override
    public String toString() {
        return "Student{" + "age="
                + age + ", name='"
                + name + '\'' + '}';
    }
}
