package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            in.lines()
                    .map(s -> s.split(" "))
                    .filter(strings -> strings[strings.length - 2].equals("404"))
                    .map(strings -> String.join(" ", strings))
                    .forEach(lines::add);
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.stream()
                    .map(s -> s + System.lineSeparator())
                    .forEach(out::write);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}