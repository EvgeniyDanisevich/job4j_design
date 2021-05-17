package ru.job4j.design.lsp.park;

import java.util.List;

public interface Park {
    void put(Auto auto);

    boolean out(Auto auto);

    boolean accept(Auto auto);

    List<Auto> getAutos();
}
