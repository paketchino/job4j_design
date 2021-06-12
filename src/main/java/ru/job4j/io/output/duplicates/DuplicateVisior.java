package ru.job4j.io.output.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateVisior extends SimpleFileVisitor<Path> {

    List<Path> listOrigin = new ArrayList<>();
    Set<FileProperty> setDuplicate = new HashSet<>();
    FileProperty temp;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        temp = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!setDuplicate.contains(temp)) {
            listOrigin.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attributes);
    }
}
