package ru.job4j.io.output;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(path, Charset.forName("Windows-1251")))) {
            in.lines().forEach(sb::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("Windows-1251"), true))) {
            for (String datum : data) {
                writer.println(datum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./data/text.txt";
        UsageEncoding usageEncoding = new UsageEncoding();
        List<String> strings = List.of(
                "Добавляю новую строку 1" + System.lineSeparator(),
                "Добавляю новую строку 2" + System.lineSeparator(),
                "Добавляю новую строку 3" + System.lineSeparator()
        );
        for (String s : strings) {
            usageEncoding.writeDataInFile(path, strings);
        }
        String s = usageEncoding.readFile(path);
        System.out.println("The data from the file: ");
        System.out.println(s);
    }
}
