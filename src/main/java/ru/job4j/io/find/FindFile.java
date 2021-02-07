package ru.job4j.io.find;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class FindFile {

    public void writeLogFile(List<Path> sources, File target) {
        try (FileWriter fileWriter = new FileWriter(target)) {
            for (Path path : sources) {
                fileWriter.write(path.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<String> predicateDefinition(String type, String fileName) {
        Predicate<String> predicate = null;
        if (type.equals("name")) {
            predicate = s -> s.contains(fileName);
        }
        if (type.equals("mask")) {
            predicate = s -> s.contains(fileName.substring(1));
        }
        return predicate;
    }

    public static void main(String[] args) throws IOException {
        // Объявление валидатора параметров
        ArgsSearch argsSearch = new ArgsSearch(args);

        // Объявление сборщика путей искомых файлов
        SavePaths savePaths = new SavePaths(predicateDefinition(
                argsSearch.searchType(), argsSearch.fileName()));

        // Поиск и сохранение путей в сборщике
        Files.walkFileTree(Paths.get(argsSearch.directory()), savePaths);

        // Запись путей в файл
           new FindFile().writeLogFile(savePaths.getPaths(),
                   new File(argsSearch.directory() + "\\" + argsSearch.logFile()));
    }
}
