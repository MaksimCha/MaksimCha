package hwMobile.hw1;

import driverSetups.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Capabilities.ANDROID_WEB_EMULATOR;
import static enums.Links.IANA_LINK;

public class FirstWebTest extends DriverSetup {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareAndroidWeb(ANDROID_WEB_EMULATOR);
    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(IANA_LINK.getLink());
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
