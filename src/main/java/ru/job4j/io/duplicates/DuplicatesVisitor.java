package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File f = new File(file.toString());
        FileProperty fileProperty = new FileProperty(f.length(), f.getName());
        if (map.containsKey(fileProperty) && !map.get(fileProperty).equals(file)) {
            System.out.println(map.get(fileProperty).toAbsolutePath());
            System.out.println(file.toAbsolutePath());
        } else {
            map.put(fileProperty, file);
        }
        return super.visitFile(file, attrs);
    }
}