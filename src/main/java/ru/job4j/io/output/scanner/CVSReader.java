package ru.job4j.io.output.scanner;

import ru.job4j.io.output.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CVSReader {

    private final List<String> outFields = new ArrayList<>();

    public Set<Integer> readHeader(String header, String delimiter, String out, String filter) {
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
                    outFields.add(tmp[i]);
                    outFields.add(" ");
                }
            }
            if (out.equals("stdout")) {
                outFields.forEach(System.out::println);
            } else {
                writeInFile(outFields);
            }
        }
        return storageData;
    }

    private void writeInFile(List<String> file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file.toString()))) {
            file.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsValue = ArgsName.of(args);
        CVSReader reader = new CVSReader();
        reader.readHeader(argsValue.getKey("path"), argsValue.getKey("delimiter"), argsValue.getKey("out"), argsValue.getKey("filter"));
    }
}
