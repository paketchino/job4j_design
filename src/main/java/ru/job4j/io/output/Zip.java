package ru.job4j.io.output;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path files : source) {
                ZipEntry zFiles = new ZipEntry(files.toString());
                zip.putNextEntry(zFiles);
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(files.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsValues = ArgsName.of(args);
        try {
            List<Path> source = Search.search(
                    Path.of(argsValues.getKey("d")),
                    (file) -> !file.toFile().getName().endsWith("e"));
            new Zip().packFiles(source, Path.of(argsValues.getKey("o")));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
