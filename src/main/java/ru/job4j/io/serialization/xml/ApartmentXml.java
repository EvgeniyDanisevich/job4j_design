package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "apartment")
public class ApartmentXml {

    @XmlAttribute
    private int number;

    @XmlAttribute
    private int livingSpace;

    public ApartmentXml() {

    }

    public ApartmentXml(int number, int livingSpace) {
        this.number = number;
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
        ApartmentXml apartment = (ApartmentXml) o;
        return number == apartment.number
                && livingSpace == apartment.livingSpace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, livingSpace);
    }
}
