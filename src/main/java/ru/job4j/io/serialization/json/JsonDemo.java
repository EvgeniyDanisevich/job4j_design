package ru.job4j.io.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonDemo {
    public static void main(String[] args) {
//        final Building building = new Building(true, 1, "St.Petersburg", new int[]{50, 60, 70}, new Apartment(2, 60));
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(building));
//
//        final String buildingJson =
//                "{"
//                        + "\"isNewBuilding\":true,"
//                        + "\"floor\":1,"
//                        + "\"address\":\"St.Petersburg\","
//                        + "\"totalLivingSpace\":[50,60,70],"
//                        + "\"forExample\":{"
//                                        + "\"number\":2,"
//                                        + "\"livingSpace\":60"
//                                        + "}"
//                        + "}";
//
//        final Building buildingMod = gson.fromJson(buildingJson, Building.class);
//        System.out.println(buildingMod);
//        System.out.println(building.equals(buildingMod));

        JSONObject jsonApartment = new JSONObject("{\"number\":2,\"livingSpace\":60}");

        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(60);
        list.add(70);
        JSONArray jsonLivingSpaces = new JSONArray(list);

        final Building building = new Building(true, 1, "St.Petersburg", new int[]{50, 60, 70}, new Apartment(2, 60));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isNewBuilding", building.isNewBuilding());
        jsonObject.put("floor", building.getFloor());
        jsonObject.put("address", building.getAddress());
        jsonObject.put("totalLivingSpace", jsonLivingSpaces);
        jsonObject.put("forExample", jsonApartment);



        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(building).toString());
    }
}
