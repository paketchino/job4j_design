package ru.job4j.io.output;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
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

    public static void main(String[] args) {
        new Zip().packSingleFile(
                new File("./chapter_005.xml"),
                new File("./chapter_005.zip")
        );
    }
}
