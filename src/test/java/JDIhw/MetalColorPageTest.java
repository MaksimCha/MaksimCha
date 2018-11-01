package JDIhw;

import base.MetalColorPageTestInit;
import org.testng.annotations.Test;

import static JDISite.JDIExampleSite.login;
import static JDISite.JDIExampleSite.homePage;

public class MetalColorPageTest extends MetalColorPageTestInit {

    @Test
    public void loginTest() {

        //Login on JDI JDISite as User
        homePage.open();
        login();
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu

    }
}
