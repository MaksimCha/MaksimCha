package hw4.ex1;

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
import static enums.State.CHECKED;
import static enums.State.UNCHECKED;
import static enums.DropDownItems.YELLOW;
import static enums.RadioButtonItems.SELEN;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DifferentElementPageTest extends SelenideTestBase {

    private HomePageSelenide homePage;
    private DifferentElementPageSelenide differentElementPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        differentElementPage = page(DifferentElementPageSelenide.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1. Open test JDISite by URL
        homePage.openPage();

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoginTitle(PITER_CHALOVSKII);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.headServiceButtonClick();
        homePage.checkServiceDropDownContains();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.leftServiceButtonClick();
        homePage.checkServiceDropDownContains();

        //7. Open through the header menu Service -> Different Elements Page
        homePage.headServiceButtonClick();
        homePage.differentElementsButtonClick();
        differentElementPage.checkTitle();

        //8. Check interface on Different elements page, it contains all needed elements
        differentElementPage.checkDifElPageExists();

        //9. Assert that there is Right Section
        differentElementPage.checkRightSection();

        //10. Assert that there is Left Section
        differentElementPage.checkLeftSection();

        //11. Select checkboxes
        differentElementPage.selectCheckBoxes(WATER, WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementPage.checkCheckBoxesLogs(CHECKED, WIND, WATER);

        //13. Select radio
        differentElementPage.selectRadioButton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementPage.checkRadioButtonLog(SELEN);

        //15. Select in dropdown
        differentElementPage.selectDropDownButton(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementPage.checkDropDownLog(YELLOW);

        //17. Unselect and assert checkboxes
        differentElementPage.selectCheckBoxes(WATER, WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementPage.checkCheckBoxesLogs(UNCHECKED, WIND, WATER);
    }
}
