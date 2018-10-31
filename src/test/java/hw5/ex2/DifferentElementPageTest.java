package hw5.ex2;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxItems.WATER;
import static enums.CheckBoxItems.WIND;
import static enums.DropDownItems.YELLOW;
import static enums.RadioButtonItems.SELEN;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DifferentElementPageTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private DifferentElementPageSelenide differentElementPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementPageSelenide = page(DifferentElementPageSelenide.class);
    }

    @Test(threadPoolSize = 3)
    public void differentElementsPageTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle();

        //3. Perform login
        homePageSelenide.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(PITER_CHALOVSKII);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.headServiceButtonClick();
        homePageSelenide.checkServiceDropDownContains();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.leftServiceButtonClick();
        homePageSelenide.checkServiceDropDownContains();

        //7. Open through the header menu Service -> Different Elements Page
        homePageSelenide.headServiceButtonClick();
        homePageSelenide.differentElementsButtonClick();
        differentElementPageSelenide.checkTitle();

        //8. Check interface on Different elements page, it contains all needed elements
        differentElementPageSelenide.checkDifElPageExists();

        //9. Assert that there is Right Section
        differentElementPageSelenide.checkRightSection();

        //10. Assert that there is Left Section
        differentElementPageSelenide.checkLeftSection();

        //11. Select checkboxes
        differentElementPageSelenide.selectCheckBoxes(WATER);
        differentElementPageSelenide.selectCheckBoxes(WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementPageSelenide.checkCheckBoxesLogs(WIND, WATER);

        //13. Select radio
        differentElementPageSelenide.selectRadioButton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementPageSelenide.checkRadioButtonLog(SELEN);

        //15. Select in dropdown
        differentElementPageSelenide.selectDropDownButton(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementPageSelenide.checkDropDownLog(YELLOW);

        //17. Unselect and assert checkboxes
        differentElementPageSelenide.selectCheckBoxes(WATER);
        differentElementPageSelenide.selectCheckBoxes(WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementPageSelenide.checkCheckBoxesLogs(WIND, WATER);
    }
}
