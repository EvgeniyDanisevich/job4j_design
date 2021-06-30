package ru.job4j.design.lsp.menu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StdMenuTest {
    @Test
    public void whenCreatedMenu() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("First", new StringAction()));
        items.add(
                new Item("Second", new StringAction()).addSuccessors(
                        new Item("Second-First", new StringAction())));
        items.add(
                new Item("Third", new StringAction()).addSuccessors(
                        new Item("Third-First", new StringAction()),
                        new Item("Third-Second", new StringAction())));
        items.add(new Item("Fourth", new StringAction()));
        items.add(new Item("Fifth", new StringAction())
                .addSuccessors(new Item("Fifth-First", new StringAction())
                        .addSuccessors(new Item("Fifth-First-Second", new StringAction())
                                .addSuccessors(
                                        new Item("First-First-Second-First", new StringAction()),
                                        new Item("First-First-Second-Second", new StringAction())
                                ))));
        items.add(new Item("Sixth", new StringAction()));
        Generator printer = new NumberActionGenerator();
        StdMenu stdMenu = new StdMenu(items, printer);
        stdMenu.printMenu();
        stdMenu.getItems().stream()
                .map(Item::getNumber)
                .forEach(System.out::println);
    }
}