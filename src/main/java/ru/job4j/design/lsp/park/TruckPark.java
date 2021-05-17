package ru.job4j.design.lsp.park;

import java.util.ArrayList;
import java.util.List;

public class TruckPark implements Park {
    private final List<Auto> autoList = new ArrayList<>();
    private int capacity = 0;
    private final int volume;

    public TruckPark(int volume) {
        this.volume = volume;
    }

    @Override
    public void put(Auto auto) {
        autoList.add(auto);
        capacity += auto.getSize();
    }

    @Override
    public boolean out(Auto auto) {
        if (autoList.remove(auto)) {
            capacity -= auto.getSize();
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Auto auto) {
        return auto.getSize() > 1 && auto.getSize() <= (volume - capacity);
    }

    @Override
    public List<Auto> getAutos() {
        return autoList;
    }
}
