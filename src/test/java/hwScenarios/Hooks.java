package hwScenarios;

import driverSetups.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static enums.PropertyFile.NATIVE;
import static enums.PropertyFile.WEB;


/**
 * Code to be run before and after test suites.
 */
public class Hooks extends Driver {

    @BeforeSuite(groups = {"web"}, description = "Prepare driver to run Web tests")
    void setWeb() throws Exception {
        setPropertyFile(WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"}, description = "Prepare driver to run Native tests")
    void setNative() throws Exception {
        setPropertyFile(NATIVE);
        prepareDriver();
    }

    @AfterSuite(groups = {"native", "web"}, description = "Close driver")
    public void tearDown() throws Exception {
        driver().quit();
    }
}
