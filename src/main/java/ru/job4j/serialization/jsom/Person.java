package ru.job4j.serialization.jsom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int age;
    private final Conacat conacat;
    private final String[] statuses;

    public Person(boolean sex, int age, Conacat conacat, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.conacat = conacat;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex="
                + sex
                + ", age="
                + age + ", conacat="
                + conacat
                + ", statuses="
                + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Conacat("11-111"), new String[] {"Student", "Free"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                + "\"sex\":false,"
                + "\"age\":30,"
                + "\"conacat\":"
                    + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
