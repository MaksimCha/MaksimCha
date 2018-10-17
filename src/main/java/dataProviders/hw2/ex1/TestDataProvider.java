package dataProviders.hw2.ex1;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] testDataProvider() {
        return new Object[][] {
                {"To include good practices\n" +
                 "and ideas from successful\n" +
                 "EPAM project", 0},
                {"To be flexible and\n" +
                 "customizable", 1},
                {"To be multiplatform", 2},
                {"Already have good base\n" +
                 "(about 20 internal and\n" +
                 "some external projects),\n" +
                 "wish to get more…", 3}
        };
    }
}
