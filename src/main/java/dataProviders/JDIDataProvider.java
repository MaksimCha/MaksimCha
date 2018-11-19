package dataProviders;

import JSONReaders.CustomSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.FormData;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JDIDataProvider {

    @DataProvider(parallel = true)
    public Object[][] JDIFormDataProvider() throws Exception {
        Map<String, FormData> dataSet = readFromJSON();
        Object[][] objectDataSet = new Object[dataSet.size()][1];
        int i = 0;
        for (FormData data : dataSet.values()) {
            objectDataSet[i][0] = data;
            ++i;
        }
        return objectDataSet;
    }

    private Map<String, FormData> readFromJSON() throws Exception{
        Type itemsMapType = new TypeToken<Map<String, FormData>>() {}.getType();
        GsonBuilder builder = new GsonBuilder();
        // TODO This can be loaded with default Serializer...
        builder.registerTypeAdapter(FormData.class, new CustomSerializer());
        Gson gson = builder.create();
        return gson.fromJson(new FileReader("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json"), itemsMapType);
    }
}
