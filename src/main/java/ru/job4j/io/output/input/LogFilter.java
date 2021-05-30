package ru.job4j.io.output.input;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> filter = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String []lines = line.split(" ");
                if ("404".equals(lines[lines.length - 2])) {
                    filter.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }

    public static void main(String[] args) {
        List<String> log = LogFilter.filter("log.txt");
        System.out.println(log);
    }
}
