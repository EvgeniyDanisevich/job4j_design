package ru.job4j.io;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private String findParam(Predicate<String> predicate) {
        Optional<String> optional = Arrays.stream(args)
                .filter(predicate)
                .map(s -> s.substring(3))
                .filter(s -> s.length() != 0)
                .findFirst();
        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public String directory() {
        valid();
        return findParam(s -> s.contains("-d="));
    }

    public String exclude() {
        valid();
        return findParam(s -> s.contains("-e="));
    }

    public String output() {
        valid();
        return findParam(s -> s.contains("-o="));
    }
}