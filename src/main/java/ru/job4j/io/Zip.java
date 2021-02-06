package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(
                        new ZipEntry(path.toFile().getAbsolutePath().substring(3)));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("C:\\projects\\job4j_design\\pom.xml"),
                new File("C:\\projects\\job4j_design\\pom.zip")
        );

        ArgZip argZip = new ArgZip(args);
        SearchFiles searchFiles = new SearchFiles(
                path -> !path.toFile().getName().endsWith(argZip.exclude())
        );
        Files.walkFileTree(Paths.get(argZip.directory()), searchFiles);
        new Zip().packFiles(
                searchFiles.getPaths(),
                new File(argZip.directory() + "\\" + argZip.output())
        );
    }
}