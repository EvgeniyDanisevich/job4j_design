package ru.job4j.design.lsp.menu;

import java.util.List;
import java.util.Map;

public interface Generator {
    List<String> generate(List<Item> items);

    Map<String, Action> getActionMap();
}
