package ru.job4j.design.lsp.park;

import java.util.ArrayList;
import java.util.List;

public class CarPark implements Park {
    private final List<Auto> carList = new ArrayList<>();
    private final List<Auto> truckList = new ArrayList<>();
    private int capacity = 0;
    private final int volume;

    public CarPark(int volume) {
        this.volume = volume;
    }

    public List<Auto> getCarList() {
        return carList;
    }

    public List<Auto> getTruckList() {
        return truckList;
    }

    @Override
    public void put(Auto auto) {
        if (auto.getSize() == 1) {
            carList.add(auto);
            capacity++;
        } else {
            truckList.add(auto);
            capacity += auto.getSize();
        }
    }

    @Override
    public boolean out(Auto auto) {
        if (auto.getSize() == 1 && carList.remove(auto)) {
            capacity--;
            return true;
        }
        if (auto.getSize() > 1 && truckList.remove(auto)) {
            capacity -= auto.getSize();
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Auto auto) {
        return  auto.getSize() <= (volume - capacity);
    }

    @Override
    public List<Auto> getAutos() {
        List<Auto> autoList = new ArrayList<>();
        autoList.addAll(carList);
        autoList.addAll(truckList);
        return autoList;
    }
}
