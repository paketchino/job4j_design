package ru.job4j.serialization.jsom;

import org.json.JSONPropertyIgnore;

public class A {
    private B b;


    public String getHello() {
        return "Hello";
    }


    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
