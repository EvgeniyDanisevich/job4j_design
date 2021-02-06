package ru.job4j.serialization.json;

import java.util.Arrays;
import java.util.Objects;

public class Building {
    private boolean isNewBuilding;
    private int floor;
    private String address;
    private int[] totalLivingSpace;
    private Apartment forExample;

    public Building(boolean isNewBuilding, int floor,
                    String address, int[] totalLivingSpace, Apartment forExample) {
        this.isNewBuilding = isNewBuilding;
        this.floor = floor;
        this.address = address;
        this.totalLivingSpace = totalLivingSpace;
        this.forExample = forExample;
    }

    public boolean isNewBuilding() {
        return isNewBuilding;
    }

    public void setNewBuilding(boolean newBuilding) {
        isNewBuilding = newBuilding;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getTotalLivingSpace() {
        return totalLivingSpace;
    }

    public void setTotalLivingSpace(int[] totalLivingSpace) {
        this.totalLivingSpace = totalLivingSpace;
    }

    public Apartment getForExample() {
        return forExample;
    }

    public void setForExample(Apartment forExample) {
        this.forExample = forExample;
    }

    @Override
    public String toString() {
        return "Home{" +
                "isNewBuilding=" + isNewBuilding
                + ", floor=" + floor
                + ", address='" + address + '\''
                + ", totalLivingSpace=" + Arrays.toString(totalLivingSpace)
                + ", forExample=" + forExample
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return isNewBuilding == building.isNewBuilding
                && floor == building.floor
                && Objects.equals(address, building.address)
                && Arrays.equals(totalLivingSpace, building.totalLivingSpace)
                && Objects.equals(forExample, building.forExample);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isNewBuilding, floor, address, forExample);
        result = 31 * result + Arrays.hashCode(totalLivingSpace);
        return result;
    }
}
