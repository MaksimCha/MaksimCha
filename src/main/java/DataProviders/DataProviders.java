package DataProviders;

public class DataProviders {
    @org.testng.annotations.DataProvider
    public Object[][] simpleDataProvider(){
        return new Object[][] {
                {"String", 1},
                {"String", 2},
                {"String", 3}
        };
    }
}
