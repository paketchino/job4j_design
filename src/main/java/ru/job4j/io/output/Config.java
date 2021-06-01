package ru.job4j.io.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader (
                new FileReader(this.path))) {
            String line = read.readLine();
            while (line != null) {
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String []val = line.split("=");
                    if (val.length == 1) {
                        throw new IllegalStateException();
                    }
                    values.put(val[0], val[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (values.containsKey(key)) {
            return values.get(key);
        }
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return Objects.equals(path, config.path) && Objects.equals(values, config.values);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, values);
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
