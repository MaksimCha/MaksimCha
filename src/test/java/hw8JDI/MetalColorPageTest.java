package hw8JDI;

import base.MetalColorPageTestInit;
import dataProviders.JDIDataProvider;
import entities.MetalColorsPageData;
import org.testng.annotations.Test;

import static JDISite.JDIExampleSite.homePage;
import static JDISite.JDIExampleSite.metalColorPage;
import static enums.Users.PITER_CHALOVSKII;

public class MetalColorPageTest extends MetalColorPageTestInit {

    @Test(dataProvider = "JDIFormDataProvider", dataProviderClass = JDIDataProvider.class, threadPoolSize = 5)
    public void loginTest(MetalColorsPageData dataSet) {

        //Login on JDI JDISite as User
        homePage.open();
        homePage.login(PITER_CHALOVSKII);
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        metalColorPage.open();
        metalColorPage.checkOpened();

        //Fill form Metals & Colors by data below:
        metalColorPage.fillForm(dataSet);

        //Submit form Metals & Colors
        metalColorPage.submitButtonClick();

        //Result sections should contains data  below:
        metalColorPage.checkResult(dataSet);
    }
}
