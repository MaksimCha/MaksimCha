package hw4.ex2;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Dates Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DatesPageTest extends SelenideTestBase {

    private DatesPageSelenide datesPage;
    private HomePageSelenide homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        datesPage = page(DatesPageSelenide.class);
    }

    @Test
    public void datesPageTest() {

        //1. Open test JDISite by URL
        homePage.openPage();

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoginTitle(PITER_CHALOVSKII);

        //5. Open through the header menu Service -> Dates Page
        homePage.datesButtonClick();
        datesPage.checkTitle();

        //6. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most right position
        datesPage.dragAndDropSlider(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs(0, 100);

        //8. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most left position.
        datesPage.dragAndDropSlider(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs(0, 0);

        //10. Using drag-and-drop set Range sliders.
        // left sliders - the most right position,
        // right slider - the most right position.
        datesPage.dragAndDropSlider(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs(100, 100);

        //12. Using drag-and-drop set Range sliders.
        datesPage.dragAndDropSlider(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs(30, 70);
    }
}
