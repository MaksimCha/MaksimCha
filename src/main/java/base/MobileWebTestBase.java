package base;

import driverSetups.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static enums.Capabilities.ANDROID_WEB_EMULATOR;

public class MobileWebTestBase extends DriverSetup {

    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareAndroidWeb(ANDROID_WEB_EMULATOR);
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }
}
