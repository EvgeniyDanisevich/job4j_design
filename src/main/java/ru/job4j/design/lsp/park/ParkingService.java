package ru.job4j.design.lsp.park;

import java.util.List;

public class ParkingService {
    private final List<Park> parkList;

    public ParkingService(List<Park> parkList) {
        this.parkList = parkList;
    }

    public void addAuto(Auto auto) {
        for (Park park : parkList) {
            if (park.priority(auto) && park.accept(auto)) {
                park.put(auto);
                break;
            }
            if (!park.priority(auto) && park.accept(auto)) {
                park.put(auto);
                break;
            }
        }
    }

    public void removeAuto(Auto auto) {
        parkList.forEach(park -> park.out(auto));
    }
}
