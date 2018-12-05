package hwScenarios.webTests;

import driverSetups.Driver;
import org.testng.annotations.Test;

import static enums.Titles.IANA_TITLE;
import static org.testng.AssertJUnit.assertEquals;

public class WebTests extends Driver {

    @Test(description = "Open site and check it opens correct", groups = "web")
    public void webTest() throws Exception {

        // Go to the site
        getDriver().get(SUT);

        // Check url is correct
        assertEquals(SUT + "/", getDriver().getCurrentUrl());

        // Check title is correct
        assertEquals(getDriver().getTitle() ,IANA_TITLE.getTitle());
    }
}
