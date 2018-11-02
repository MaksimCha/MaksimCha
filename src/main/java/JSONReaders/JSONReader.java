package JSONReaders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.FormData;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader {

    public Map<String, FormData> readFromJSON() throws Exception{
        Type itemsMapType = new TypeToken<Map<String, FormData>>() {}.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FormData.class, new CustomSerializer());
        Gson gson = builder.create();
        return gson.fromJson(new FileReader("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json"), itemsMapType);
    }
}
