package ru.job4j.io.serialization.xml;

import ru.job4j.io.serialization.json.Building;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlDemo {
    public static void main(String[] args) throws Exception {
        BuildingXml building = new BuildingXml(
                true, 1, "St.Petersburg", new int[]{50, 60, 70}, new ApartmentXml(2, 60));
        JAXBContext context = JAXBContext.newInstance(BuildingXml.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(building, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            BuildingXml result = (BuildingXml) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
