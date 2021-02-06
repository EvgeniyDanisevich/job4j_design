package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonDemo {
    public static void main(String[] args) {
        final Building building = new Building(
                true, 1, "St.Petersburg", new int[]{50, 60, 70}, new Apartment(2, 60)
        );
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(building));

        final String buildingJson =
                "{"
                        + "\"isNewBuilding\":true,"
                        + "\"floor\":1,"
                        + "\"address\":\"St.Petersburg\","
                        + "\"totalLivingSpace\":[50,60,70],"
                        + "\"forExample\":{"
                                        + "\"number\":2,"
                                        + "\"livingSpace\":60"
                                        + "}"
                        + "}";

        final Building buildingMod = gson.fromJson(buildingJson, Building.class);
        System.out.println(buildingMod);
        System.out.println(building.equals(buildingMod));
    }
}
