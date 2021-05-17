package ru.job4j.design.lsp.park;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceTest {

    private final Auto car1 = new Auto("Car1", 1);
    private final Auto car2 = new Auto("Car2", 1);
    private final Auto car3 = new Auto("Car3", 1);

    private final List<Auto> carList = List.of(car1, car2, car3);

    private final Auto truck1 = new Auto("Truck1", 3);
    private final Auto truck2 = new Auto("Truck2", 3);
    private final Auto truck3 = new Auto("Truck3", 3);
    private final Auto truck4 = new Auto("Truck4", 2);

    private final List<Auto> truckList = List.of(truck1, truck2, truck3, truck4);

    private final List<Auto> autoList = List.of(car1, car2, car3, truck1, truck2, truck3, truck4);

    @Test
    public void whenAddAllAuto() {
        Park truckPark = new TruckPark(9);
        Park carPark = new CarPark(5);
        List<Park> parkList = new ArrayList<>();
        parkList.add(truckPark);
        parkList.add(carPark);
        ParkingService parkingService = new ParkingService(parkList);
        autoList.forEach(parkingService::addAuto);
        assertEquals(List.of(car1, car2, car3, truck4), carPark.getAutos());
        assertEquals(List.of(truck1, truck2, truck3), truckPark.getAutos());
    }

    @Test
    public void whenAddTruckAuto() {
        Park truckPark = new TruckPark(9);
        Park carPark = new CarPark(5);
        List<Park> parkList = new ArrayList<>();
        parkList.add(truckPark);
        parkList.add(carPark);
        ParkingService parkingService = new ParkingService(parkList);
        truckList.forEach(parkingService::addAuto);
        assertEquals(List.of(truck1, truck2, truck3), truckPark.getAutos());
        assertEquals(List.of(truck4), carPark.getAutos());
    }

    @Test
    public void whenAddCarAuto() {
        Park truckPark = new TruckPark(9);
        Park carPark = new CarPark(5);
        List<Park> parkList = new ArrayList<>();
        parkList.add(truckPark);
        parkList.add(carPark);
        ParkingService parkingService = new ParkingService(parkList);
        carList.forEach(parkingService::addAuto);
        assertEquals(List.of(car1, car2, car3), carPark.getAutos());
        assertEquals(List.of(), truckPark.getAutos());
    }

    @Test
    public void whenOutTwoCarAndAddTruck() {
        Park truckPark = new TruckPark(9);
        Park carPark = new CarPark(5);
        List<Park> parkList = new ArrayList<>();
        parkList.add(truckPark);
        parkList.add(carPark);
        ParkingService parkingService = new ParkingService(parkList);
        autoList.forEach(parkingService::addAuto);
        parkingService.removeAuto(car1);
        parkingService.removeAuto(car2);
        parkingService.addAuto(truck4);
        assertEquals(List.of(car3, truck4, truck4), carPark.getAutos());
        assertEquals(List.of(truck1, truck2, truck3), truckPark.getAutos());
    }
}