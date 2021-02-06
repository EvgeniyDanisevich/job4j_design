package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> filteredLines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            boolean flag = false;
            String str;
            String begin = null;
            String end = null;
            while ((str = in.readLine()) != null) {
                if ((str.startsWith("400") || str.startsWith("500")) && !flag) {
                    begin = str.substring(4);
                    flag = true;
                }
                if ((str.startsWith("200") || str.startsWith("300")) && (flag)) {
                    end = str.substring(4);
                    flag = false;
                }
                if (begin != null && end != null) {
                    filteredLines.add(String.format("%s;%s", begin, end));
                    begin = null;
                    end = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            filteredLines.forEach(out::println);
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