package ru.job4j.io.output.input;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> filter = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] lines = line.split(" ");
                if ("404".equals(lines[lines.length - 2])) {
                    filter.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            out.printf("%s%n", log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = LogFilter.filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}
