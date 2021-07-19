package ru.job4j.io.output.scanner;
//
import ru.job4j.io.output.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CVSReader {

    private Set<Integer> readHeader(String header, String filter, String delimiter) {
        Set<Integer> storageData = new HashSet<>();
        String[] headers = header.split(delimiter);
        Set<String> filters = new HashSet<>(Arrays.asList(filter.split(",")));
        for (int i = 0; i < headers.length; i++) {
            if (filters.contains(headers[i])) {
                storageData.add(i);
            }
        }
        try (var scanner = new Scanner(new ByteArrayInputStream(header.getBytes()))) {
            String[] tmp = scanner.next().split(delimiter);
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].contains(filter)) {
                    storageData.add(i);
                }
            }
        }
        return storageData;
    }

    public void writeInFile(String out, Set<Integer> file) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(out))) {
            file.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsValue = ArgsName.of(args);
        CVSReader reader = new CVSReader();
        reader.writeInFile(argsValue.getKey("out"),
                reader.readHeader(argsValue.getKey("path"),
                        argsValue.getKey("filter"),
                        argsValue.getKey("delimiter")));
    }
}
