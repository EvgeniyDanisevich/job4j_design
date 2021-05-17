package ru.job4j.design.lsp.park;

import java.util.Objects;

public class Auto {
    private String number;
    private int size;

    public Auto(String number, int size) {
        this.number = number;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return size == auto.size && Objects.equals(number, auto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size);
    }

    @Override
    public String toString() {
        return "Auto{"
                + "number='" + number + '\''
                + ", size=" + size
                + '}';
    }
}
