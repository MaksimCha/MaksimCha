package hwScenarious;

import base.MobileWebTestBase;
import org.testng.annotations.Test;

import static enums.Links.IANA_LINK;

public class FirstWebTest extends MobileWebTestBase {

    @Test(description = "Open website")
    public void webTest() {
        driver.get(IANA_LINK.getLink());
    }
}
