package ru.job4j.searchingFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Field {

    private void writeFile(String source, List<Path> log) {
        try (PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream(log.toString())))) {
            for (Path path : log) {
                pr.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Predicate<Path> searchByTheFiles(String typeOfSearch, String value) {
        Predicate<Path> condition;
        switch (typeOfSearch) {
            case "name":
                condition = (file) -> file.toFile().getName().equals(value);
                break;
            case "mask":
                condition = (file) -> file.toFile().getName().endsWith(value.substring(1));
                break;
            case "regex":
                condition = file -> file.toFile().getName().matches(value);
                break;
            default:
                condition = null;
        }
        return condition;
    }

    public static void main(String[] args) throws IOException {
        ArgsName values = ArgsName.of(args);
        Visitor visitor = new Visitor(searchByTheFiles(values.getKet("t"), values.getKet("n")));
        Files.walkFileTree(Paths.get(values.getKet("d")), visitor);
        List<Path> log = visitor.getPaths();
        new Field().writeFile(values.getKet("o"), log);
    }
}
