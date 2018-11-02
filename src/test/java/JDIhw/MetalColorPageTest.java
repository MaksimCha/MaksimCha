package JDIhw;

import base.MetalColorPageTestInit;
import dataProviders.JDIDataProvider;
import entities.FormData;
import org.testng.annotations.Test;

import static JDISite.JDIExampleSite.*;

public class MetalColorPageTest extends MetalColorPageTestInit {

    @Test(dataProvider = "JDIFormDataProvider", dataProviderClass = JDIDataProvider.class, threadPoolSize = 3)
    public void loginTest(FormData dataSet) {

        //Login on JDI JDISite as User
        homePage.open();
        login();
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        metalColorPage.open();
        metalColorPage.checkOpened();

        //Fill form Metals & Colors by data below:
        fillForm(dataSet);

        //Submit form Metals & Colors
        submitButtonClick();
    }
}
