package ru.job4j.searchingFiles;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Field {

    public void writeFile(List<Path> source, Path log) {
        try (PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream(log.toString())));
             BufferedReader br = new BufferedReader(new FileReader(source.toString()))) {
            String read;
            while ((read = br.readLine()) != null) {
                if (!read.isEmpty()) {
                    pr.printf(read);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName values = ArgsName.of(args);
        try {
            List<Path> source = Search.search(
                    Path.of(values.getKet("d")),
                    (file) -> file.toFile().getName().equals("n") || file.toFile().getName().endsWith("t")
            );
            new Field().writeFile(source, Path.of(values.getKet("o")));
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
