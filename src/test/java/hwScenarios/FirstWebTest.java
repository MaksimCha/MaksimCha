package hwScenarios;

import base.MobileWebTestBase;
import org.testng.annotations.Test;

import static enums.Links.IANA_LINK;

public class FirstWebTest extends MobileWebTestBase {

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(IANA_LINK.getLink());
        System.out.println("Site opening done");
    }
}
