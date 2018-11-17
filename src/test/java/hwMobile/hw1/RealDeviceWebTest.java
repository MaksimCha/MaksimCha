package hwMobile.hw1;

import base.RealDeviceWebTestBase;
import org.testng.annotations.Test;

import static enums.Links.IANA_LINK;

public class RealDeviceWebTest extends RealDeviceWebTestBase {

    @Test(description = "Open website")
    public void webTest() {
        driver.get(IANA_LINK.getLink());
        System.out.println("Site opening done");
    }
}
