package dataProviders;

import JSONReaders.JSONReader;
import entities.FormData;
import org.testng.annotations.DataProvider;

import java.util.Map;

public class JDIDataProvider {

    @DataProvider(parallel = true)
    public Object[][] JDIFormDataProvider() throws Exception {
        // TODO This will be better with TypeToken
        JSONReader reader = new JSONReader();
        Map<String, FormData> dataSet = reader.readFromJSON();
        Object[][] objectDataSet = new Object[dataSet.size()][1];
        int i = 0;
        for (FormData data : dataSet.values()) {
            objectDataSet[i][0] = data;
            ++i;
        }
        return objectDataSet;
    }
}
