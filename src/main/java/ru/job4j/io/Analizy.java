package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> lines = new ArrayList<>();
        List<String> filteredLines = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<String> datesFormat = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().forEach(lines::add);
            boolean flag = false;
            for (String str : lines) {
                if ((str.startsWith("400") || str.startsWith("500")) && !flag) {
                    filteredLines.add(str);
                    flag = true;
                }
                if ((str.startsWith("200") || str.startsWith("300"))
                        && (flag || !filteredLines.isEmpty())) {
                    filteredLines.add(str);
                    flag = false;
                }
            }
            filteredLines.stream()
                    .map(s -> s.split(" "))
                    .forEach(strings -> dates.add(strings[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (int i = 0; i < dates.size(); i++) {
                if (i % 2 == 0) {
                    datesFormat.add(dates.get(i) + ";" + dates.get(i + 1) + System.lineSeparator());
                }
            }
            datesFormat.forEach(out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy analizy = new Analizy();
        analizy.unavailable("server.txt", "target.txt");
    }
}