package ru.job4j.io.find;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class ArgsSearch {
    private String[] args;

    public ArgsSearch(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 4) {
            throw new IllegalArgumentException("Недостаточно аргументов, необходимо: "
                    + "-d=директория -n=*.txt(полное имя файла или имя по маске) "
                    + "-t=mask(тип поиска mask - по маске, name - по имени) "
                    + "-o=log.txt(имя лог-файла, сохранится в директории поиска)");
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
            throw new IllegalArgumentException("Не все аргументы указаны, необходимо: "
                    + "-d=директория -n=*.txt(полное имя файла или имя по маске) "
                    + "-t=mask(тип поиска mask - по маске, name - по имени) "
                    + "-o=log.txt(имя лог-файла, сохранится в директории поиска)");
        }
        return optional.get();
    }

    public String directory() {
        valid();
        return findParam(s -> s.contains("-d="));
    }

    public String fileName() {
        valid();
        return findParam(s -> s.contains("-n="));
    }

    public String searchType() {
        valid();
        String t = findParam(s -> s.contains("-t="));
        if (!(t.equals("name") || t.equals("mask"))) {
            throw new IllegalArgumentException();
        }
        return t;
    }

    public String logFile() {
        valid();
        return findParam(s -> s.contains("-o="));
    }
}
