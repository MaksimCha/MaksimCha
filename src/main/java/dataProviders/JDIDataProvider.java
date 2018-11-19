package dataProviders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.MetalColorsPageData;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JDIDataProvider {

    @DataProvider(parallel = true)
    public Object[][] JDIFormDataProvider() throws Exception {
        Map<String, MetalColorsPageData> dataSet = readFromJSON();
        Object[][] objectDataSet = new Object[dataSet.size()][1];
        int i = 0;
        for (MetalColorsPageData data : dataSet.values()) {
            objectDataSet[i][0] = data;
            ++i;
        }
        return objectDataSet;
    }

    private Map<String, MetalColorsPageData> readFromJSON() throws Exception{
        Type itemsMapType = new TypeToken<Map<String, MetalColorsPageData>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(new FileReader("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json"), itemsMapType);
    }
}
