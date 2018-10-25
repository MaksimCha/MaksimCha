package hw5.ex1;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.ServicePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxItems.WATER;
import static enums.CheckBoxItems.WIND;
import static enums.DropDownItems.YELLOW;
import static enums.RadioButtonItems.SELEN;
import static enums.Titles.LOGIN_TITLE;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private ServicePageSelenide servicePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        servicePageSelenide = page(ServicePageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle();

        //3. Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(LOGIN_TITLE.title);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.headServiceButtonRealise();
        homePageSelenide.checkHeadServiceDropDownContains();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.leftServiceButtonRealise();
        homePageSelenide.checkLeftServiceDropDownContains();

        //7. Open through the header menu Service -> Different Elements Page
        homePageSelenide.headServiceButtonRealise();
        homePageSelenide.headServiceDifElRealise();
        servicePageSelenide.checkTitle();

        //8. Check interface on Different elements page, it contains all needed elements
        servicePageSelenide.checkDifElPageExists();

        //9. Assert that there is Right Section
        servicePageSelenide.checkRightSection();

        //10. Assert that there is Left Section
        servicePageSelenide.checkLeftSection();

        //11. Select checkboxes
        servicePageSelenide.selectCheckBoxes(WATER.counter, WATER.value);
        servicePageSelenide.selectCheckBoxes(WIND.counter, WIND.value);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePageSelenide.checkCheckBoxesLogs();

        //13. Select radio
        servicePageSelenide.selectRadioButton(SELEN.counter, SELEN.value);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        servicePageSelenide.checkLog(SELEN.value);

        //15. Select in dropdown
        servicePageSelenide.selectDropDownButton(YELLOW.counter, YELLOW.value);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        servicePageSelenide.checkLog(YELLOW.value);

        //17. Unselect and assert checkboxes
        servicePageSelenide.selectCheckBoxes(WATER.counter, WATER.value);
        servicePageSelenide.selectCheckBoxes(WATER.counter, WATER.value);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePageSelenide.checkCheckBoxesLogs();
    }
}
