package ru.job4j.io;

import java.io.FileOutputStream;

public class Multiple {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("multiple.txt")) {
            out.write(("1 * 2 = 2" + System.lineSeparator()).getBytes());
            out.write(("1 * 3 = 3" + System.lineSeparator()).getBytes());
            out.write(("1 * 4 = 4" + System.lineSeparator()).getBytes());
            out.write(("1 * 5 = 5" + System.lineSeparator()).getBytes());
            out.write(("1 * 6 = 6" + System.lineSeparator()).getBytes());
            out.write(("1 * 7 = 7" + System.lineSeparator()).getBytes());
            out.write(("1 * 8 = 8" + System.lineSeparator()).getBytes());
            out.write(("1 * 9 = 9" + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
