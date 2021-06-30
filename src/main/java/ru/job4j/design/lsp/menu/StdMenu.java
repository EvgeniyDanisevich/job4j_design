package ru.job4j.design.lsp.menu;

import java.util.List;
import java.util.Map;

public class StdMenu implements Menu {
    private final List<Item> items;
    private final List<String> strings;
    private final Map<String, Action> actionMap;

    public StdMenu(List<Item> items, Generator generator) {
        this.items = items;
        this.strings = generator.generate(items);
        this.actionMap = generator.getActionMap();
    }

    @Override
    public void printMenu() {
        strings.forEach(System.out::println);
    }

    @Override
    public void selectAction(String string) {
        actionMap.get(string).doSomeThing(string);
    }

    public List<Item> getItems() {
        return items;
    }
}
