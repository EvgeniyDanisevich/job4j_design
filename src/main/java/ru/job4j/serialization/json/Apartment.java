package ru.job4j.serialization.json;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return number == apartment.number
                && livingSpace == apartment.livingSpace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, livingSpace);
    }
}
