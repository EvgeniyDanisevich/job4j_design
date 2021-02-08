package ru.job4j.io.find;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgsSearch {
    private final String[] args;
    private final Map<String, String> arguments;

    public ArgsSearch(String[] args) {
        this.args = args;
        this.arguments = findArgs();
        valid();
    }

    public void valid() {
        if (args.length < 4
                || !arguments.containsKey("-d")
                || !arguments.containsKey("-n")
                || !arguments.containsKey("-t")
                || !arguments.containsKey("-o")
                || (!arguments.get("-t").equals("mask")
                && !arguments.get("-t").equals("name"))) {
            throw new IllegalArgumentException("Недостаточно аргументов, необходимо: "
                    + "-d=директория -n=*.txt(полное имя файла или имя по маске) "
                    + "-t=mask(тип поиска mask - по маске, name - по имени) "
                    + "-o=log.txt(имя лог-файла, сохранится в директории поиска)");
        }
    }

    private Map<String, String> findArgs() {
        return Arrays.stream(args)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
    }

    public String directory() {
        return arguments.get("-d");
    }

    public String fileName() {
        return arguments.get("-n");
    }

    public String searchType() {
        return arguments.get("-t");
    }

    public String logFile() {
        return arguments.get("-o");
    }
}
