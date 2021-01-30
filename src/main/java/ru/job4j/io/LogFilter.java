package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            in.lines()
                    .map(s -> s.split(" "))
                    .filter(strings -> strings[strings.length - 2].equals("404"))
                    .map(Arrays::toString)
                    .forEach(lines::add);
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}