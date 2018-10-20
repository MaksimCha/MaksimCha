package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.TestedPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Titles.HOME_PAGE_TITLE;
import static enums.Titles.LOGIN_TITLE;
import static enums.Users.PITER_CHAILOWSKI;

public class SelenidePageObjectTest extends SelenideTestBase {

    private TestedPageSelenide testedPageSelenide;

    @BeforeClass
    public void beforeClass() {
        testedPageSelenide = page(TestedPageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1. Open test site by URL
        testedPageSelenide.openPage();

        //2. Assert Browser title
        testedPageSelenide.checkTitle(HOME_PAGE_TITLE.title);

        //3. Perform login
        testedPageSelenide.login(PITER_CHAILOWSKI.login, PITER_CHAILOWSKI.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        testedPageSelenide.checkLoginTitle(LOGIN_TITLE.title);

        //5. Open through the header menu Service -> Dates Page
        testedPageSelenide.realiseDatesButton();
        testedPageSelenide.checkDatesPageDisplaying();

        //6. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most rigth position

    }
}
