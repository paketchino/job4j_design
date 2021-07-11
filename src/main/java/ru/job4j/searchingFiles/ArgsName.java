package ru.job4j.searchingFiles;
//
import java.util.*;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String getKet(String key) {
        if (values.size() == 0) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    public void parse(String[] args) {
        for (String s : args) {
            String[] str = s.split("=");
            if (str.length == 1) {
                throw new IllegalArgumentException();
            }
            values.put(args[0].substring(1), args[1]);
        }
    }

    public static ArgsName of (String[] args) {
        ArgsName argsName = new ArgsName();
        argsName.parse(args);
        return argsName;
    }
}
