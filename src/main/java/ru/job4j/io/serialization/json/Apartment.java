package ru.job4j.io.serialization.json;

public class Apartment {
    private int number;
    private int livingSpace;

    public Apartment(int number, int livingSpace) {
        this.number = number;
        this.livingSpace = livingSpace;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(int livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Override
    public String toString() {
        return "Apartment{"
                + "number=" + number
                + ", livingSpace=" + livingSpace
                + '}';
    }
}
