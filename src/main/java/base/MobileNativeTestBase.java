package base;

import driverSetups.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static enums.Capabilities.ANDROID_EMULATOR;

public class MobileNativeTestBase extends DriverSetup {

    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareAndroidNative(ANDROID_EMULATOR);
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() {
        driver.quit();
    }
}
