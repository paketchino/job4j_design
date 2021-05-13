package ru.job4j.hash;

import java.lang.reflect.Type;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Objects;
import java.util.HashMap;

import static java.util.Calendar.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof User)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(children);
        result = 31 * result + Integer.hashCode(children);
        return result;
    }
}
