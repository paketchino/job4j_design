package ru.job4j.searchingFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    private final Path root;

    public Search(Path root) {
        this.root = root;
    }

    public static List<Path> search (Path root, Predicate<Path> condition) throws IOException {
        Visitor visitor = new Visitor(condition);
        Files.walkFileTree(root, visitor);
        return visitor.getPaths();
    }
}
