package ru.job4j.hash;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserFiled {
    public static void main(String[] args) {
        Calendar calendar1 = new GregorianCalendar(2000, 9, 9);
        Calendar calendar2 = new GregorianCalendar(2000, 9, 9);
        User u1 = new User("Roman", 23, calendar1);
        User u2 = new User("Roman", 23, calendar2);

        Map<User, Object> userMap = new HashMap<>();
        userMap.put(u1, new Object());
        userMap.put(u2, new Object());
        for (Map.Entry<User, Object> u : userMap.entrySet()) {
            System.out.println("Это ключ: " + u.getKey());
        }
        System.out.println(u1.equals(u2));

    }
}
