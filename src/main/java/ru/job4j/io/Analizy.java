package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> filteredLines = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<String> datesFormat = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            boolean flag = false;
            String str;
            while ((str = in.readLine()) != null) {
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
            for (int i = 0; i < dates.size(); i = i + 2) {
                datesFormat.add(dates.get(i) + ";" + dates.get(i + 1));
            }
            datesFormat.forEach(out::println);
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