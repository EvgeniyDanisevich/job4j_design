package ru.job4j.design.lsp.menu;

public class StringAction implements Action {
    @Override
    public void doSomeThing(String string) {
        System.out.println("You chose " + string);
    }
}
