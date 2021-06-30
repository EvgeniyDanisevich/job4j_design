package ru.job4j.design.lsp.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {
    private String precursor = "";
    private String name;
    private String number = "";
    private String title = "";
    private List<Item> successors = new ArrayList<>();
    private Action action;

    public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getPrecursor() {
        return precursor;
    }

    public void setPrecursor(String precursor) {
        this.precursor = precursor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Item> successors) {
        this.successors = successors;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item addSuccessors(Item... items) {
        successors.addAll(Arrays.asList(items));
        return this;
    }

    public Action getAction() {
        return action;
    }
}
