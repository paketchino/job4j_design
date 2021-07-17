package ru.job4j.io.output.scanner;
//
import ru.job4j.io.output.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CVSReader {

    private Set<Integer> readHeader(String header, String filter) {
        Set<Integer> tempStorage = new HashSet<>();
        try (var scanner = new Scanner(new ByteArrayInputStream(header.getBytes()))) {
            while (scanner.hasNext()) {
                if (scanner.next().equals(filter)) {
                    tempStorage.add(Integer.parseInt(scanner.next()));
                }
                scanner.close();
            }
        }
        return tempStorage;
    }
    public static void main(String[] args) throws IOException {
        ArgsName argsValues = ArgsName.of(args);
        var path = argsValues.getKey("path");
        var delimiter = argsValues.getKey("delimiter");
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(path.getBytes())).useDelimiter(delimiter)) {
            while (scanner.hasNext()) {
                var result = scanner.findInLine(argsValues.getKey("filter"));
                if (scanner.next().contains(result)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(result);
                    System.out.println(sb);
                }
            }
       }
    }
}
