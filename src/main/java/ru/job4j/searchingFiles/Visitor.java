package ru.job4j.searchingFiles;
//
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Visitor extends SimpleFileVisitor<Path> {
    private final Predicate<Path> condition;
    private List<Path> log = new ArrayList<>();

    public Visitor(Predicate<Path> condition) {
        this.condition = condition;
    }

    public List<Path> getPaths() {
        return log;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            log.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
