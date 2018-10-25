package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatesPageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "div.profile-photo > span")
    private SelenideElement loginTitle;

    @FindBy(css = ".m-l8 [class = 'dropdown-toggle']")
    private SelenideElement serviceButton;

    @FindBy(css = ".m-l8 [href = 'dates.html']")
    private SelenideElement datesButton;

    private ElementsCollection sliderItems = $$(By.cssSelector("a.ui-corner-all"));

    private SelenideElement slider = $(By.cssSelector("div.ui-corner-all"));

    private ElementsCollection Logs = $$(By.cssSelector(".panel-body-list.logs > li"));
    //==============================methods==================================

    @Step
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    public void realiseDatesButton() {
        serviceButton.click();
        datesButton.click();
    }

    @Step
    public void dragAndDropSlider(int position, boolean side) {
        SelenideElement slider = side?sliderItems.first():sliderItems.last();
        setSliderPosition(position, slider);
    }

    @Step
    private void setSliderPosition(Integer position, SelenideElement sliderItem) {
        double width = (double) slider.getSize().getWidth();
        Actions act = new Actions(getWebDriver());
        Double currentPosition = Double.parseDouble(sliderItem.getCssValue("left").replaceAll("px", "")) / (width / 100);
        int xOffset = (int) ((position - currentPosition - 1) * (width / 100));
        act.dragAndDropBy(sliderItem, xOffset, 0).build().perform();
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Dates");
    }

    @Step
    public void checkSliderLogs(int leftPosition, int rightPosition, boolean inverse){
        if(inverse) {
            checkSliderLog(leftPosition, true, Logs.first().getText());
            Iterator<SelenideElement> Log = Logs.iterator();
            Log.next();
            checkSliderLog(rightPosition, false, Log.next().getText());
        }else{
            checkSliderLog(rightPosition, false, Logs.first().getText());
            Iterator<SelenideElement> Log = Logs.iterator();
            Log.next();
            checkSliderLog(leftPosition, true, Log.next().getText());
        }
    }

    @Step
    private void checkSliderLog(int position, boolean value, String expected) {
        String nameSlider = value ? "From" : "To";
        assertTrue(expected.contains(nameSlider));
        assertTrue(expected.contains(String.valueOf(position)));
    }
}
