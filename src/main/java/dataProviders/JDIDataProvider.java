package dataProviders;

import org.testng.annotations.DataProvider;

public class JDIDataProvider {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }
}
