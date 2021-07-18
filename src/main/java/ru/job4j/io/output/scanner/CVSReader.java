package ru.job4j.io.output.scanner;
//
import ru.job4j.io.output.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CVSReader {

    private Set<Integer> readHeader(String header, String filter, String delimiter) {
        Set<Integer> storageData = new HashSet<>();
        try (var scanner = new Scanner(new ByteArrayInputStream(header.getBytes()))
                .useDelimiter(delimiter)) {
            while (scanner.hasNext()) {
                String column = scanner.next();
                String[] tempStorage = column.split(",");
                for (int i = 0; i < tempStorage.length; i++) {
                    if (tempStorage[i].equals(filter)) {
                        int index = Integer.parseInt(tempStorage[i]);
                        storageData.add(index);
                    }
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
