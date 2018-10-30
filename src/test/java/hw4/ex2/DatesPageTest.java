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
import static enums.Sliders.SLIDER;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DatesPageTest extends SelenideTestBase {

    private DatesPageSelenide datesPageSelenide;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void datesPageTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle();

        //3. Perform login
        homePageSelenide.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(PITER_CHALOVSKII);

        //5. Open through the header menu Service -> Dates Page
        datesPageSelenide.datesButtonClick();
        datesPageSelenide.checkTitle();

        //6. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most right position
        datesPageSelenide.dragAndDropSlider(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSliderLogs(0, 100);

        //8. Using drag-and-drop set Range sliders.
        // left sliders - the most left position,
        // right slider - the most left position.
        datesPageSelenide.dragAndDropSlider(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSliderLogs(0, 0);

        //10. Using drag-and-drop set Range sliders.
        // left sliders - the most right position,
        // right slider - the most right position.
        datesPageSelenide.dragAndDropSlider(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSliderLogs(100, 100);

        //12. Using drag-and-drop set Range sliders.
        datesPageSelenide.dragAndDropSlider(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSliderLogs(30, 70);
    }
}
