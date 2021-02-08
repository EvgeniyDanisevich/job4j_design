package ru.job4j.io.find;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SavePaths extends SimpleFileVisitor<Path> {
    private final List<Path> paths = new ArrayList<>();
    private final Predicate<String> predicate;

    public SavePaths(Predicate<String>  predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file);
        if (predicate.test(file.toAbsolutePath().toString())) {
            paths.add(file);
        }
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return paths;
    }
}