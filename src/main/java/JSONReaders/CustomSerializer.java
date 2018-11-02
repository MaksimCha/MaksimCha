package JSONReaders;

import com.google.gson.*;
import entities.FormData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomSerializer implements JsonDeserializer<FormData> {

    @Override
    public FormData deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();

        FormData formData = new FormData();

        JsonArray jsonSummury = jsonObject.getAsJsonArray("summary");
        List<String> sums = new ArrayList<>();
        for(JsonElement summury : jsonSummury) {
            sums.add(summury.getAsString());
        }
        formData.setSummary(sums);

        JsonArray jsonElements = jsonObject.getAsJsonArray("elements");
        List<String> elements = new ArrayList<>();
        for(JsonElement element : jsonElements) {
            elements.add(element.getAsString());
        }
        formData.setElements(elements);

        formData.setColor(jsonObject.get("color").getAsString());

        formData.setMetals(jsonObject.get("metals").getAsString());

        JsonArray jsonVegetables = jsonObject.getAsJsonArray("vegetables");
        List<String> vegetables = new ArrayList<>();
        for(JsonElement vegetable : jsonVegetables) {
            vegetables.add(vegetable.getAsString());
        }
        formData.setVegetables(vegetables);

        return formData;
    }
}
