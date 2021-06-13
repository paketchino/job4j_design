package ru.job4j.io.output;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String getKey(String key) {
        if (values.size() == 0) {
            throw new IllegalArgumentException("The values not found");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            String[] temp = s.split("=");
            if (temp.length < 2) {
                throw new IllegalArgumentException();
            }
            values.put(args[0], args[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm);

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip);
    }
}
