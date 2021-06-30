package ru.job4j.design.lsp.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberActionGenerator implements Generator {
    private final List<String> strings = new ArrayList<>();
    private final Map<String, Action> actionMap = new HashMap<>();

    @Override
    public List<String> generate(List<Item> items) {
        StringBuilder titleBuilder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            titleBuilder.append(item.getPrecursor())
                    .append(item.getName())
                    .append(" ")
                    .append(item.getNumber())
                    .append((i + 1))
                    .append(".");
            item.setTitle(titleBuilder.toString());
            titleBuilder.setLength(0);
            actionMap.put(item.getNumber(), item.getAction());
            strings.add(item.getTitle());
            if (!item.getSuccessors().isEmpty()) {
                subGenerate(item.getSuccessors(), item.getPrecursor(), item.getNumber(), i);
                generate(item.getSuccessors());
            }
        }
        return strings;
    }

    private void subGenerate(List<Item> items, String precursor, String number, int i) {
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            item.setPrecursor(builder.append(precursor).append("----").toString());
            builder.setLength(0);
            item.setNumber(builder.append(number).append(i + 1).append(".").toString());
            builder.setLength(0);
        }
    }

    public Map<String, Action> getActionMap() {
        return new HashMap<>(actionMap);
    }
}
