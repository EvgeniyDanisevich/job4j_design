package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.Objects;


@XmlRootElement(name = "building")
@XmlAccessorType(XmlAccessType.FIELD)
public class BuildingXml {

    @XmlAttribute
    private boolean isNewBuilding;

    @XmlAttribute
    private int floor;
    private String address;

    @XmlElementWrapper(name = "totalLivingSpace")
    @XmlElement(name = "livingSpace")
    private int[] totalLivingSpace;

    @XmlElement
    private ApartmentXml forExample;

    public BuildingXml() {

    }

    public BuildingXml(boolean isNewBuilding, int floor,
                       String address, int[] totalLivingSpace, ApartmentXml forExample) {
        this.isNewBuilding = isNewBuilding;
        this.floor = floor;
        this.address = address;
        this.totalLivingSpace = totalLivingSpace;
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
        BuildingXml building = (BuildingXml) o;
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
