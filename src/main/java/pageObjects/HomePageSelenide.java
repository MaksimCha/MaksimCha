package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.*;
import static enums.Titles.EIGHTH_SERVICE_LEFTER;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

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

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeadButton;

    @FindBy(css = ".sidebar-menu .menu-title")
    private SelenideElement serviceLeftButton;

    private ElementsCollection serviceHeadListItems = $$(By.cssSelector(".m-l8 .dropdown-menu > li > a"));

    private ElementsCollection serviceLeftListItems = $$(By.cssSelector(".sidebar-menu .menu-title [class = 'sub'] li > a"));

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElementsButton;

    //==============================methods==================================

    @Step
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    public void headServiceButtonRealise() {
        serviceHeadButton.click();
    }

    @Step
    public void leftServiceButtonRealise() {
        serviceLeftButton.click();
    }

    @Step
    public void headServiceDifElRealise(){
        differentElementsButton.click();
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), HOME_PAGE_TITLE.title);
    }

    @Step
    public void checkLoginTitle(String title) {
        loginTitle.shouldHave(text(title));
    }

    @Step
    public void checkHeadServiceDropDownContains(){
        ArrayList<String> expectedTitles = new ArrayList<String>();
        expectedTitles.add(FIRST_SERVICE_HEADER.title);
        expectedTitles.add(SECOND_SERVICE_HEADER.title);
        expectedTitles.add(THIRD_SERVICE_HEADER.title);
        expectedTitles.add(FOURTH_SERVICE_HEADER.title);
        expectedTitles.add(FIFTH_SERVICE_HEADER.title);
        expectedTitles.add(SIXTH_SERVICE_HEADER.title);
        expectedTitles.add(SEVENTH_SERVICE_HEADER.title);
        expectedTitles.add(EIGHTH_SERVICE_HEADER.title);

        assertEquals(serviceHeadListItems.size(), expectedTitles.size());
        Iterator<SelenideElement> serviceListItem = serviceHeadListItems.iterator();
        Iterator<String> itemText = expectedTitles.iterator();
        while (serviceListItem.hasNext() && itemText.hasNext()) {
            assertEquals(serviceListItem.next().getText(), itemText.next());
        }
    }

    @Step
    public void checkLeftServiceDropDownContains() {
        ArrayList<String> expectedTitles = new ArrayList<String>();
        expectedTitles.add(FIRST_SERVICE_LEFTER.title);
        expectedTitles.add(SECOND_SERVICE_LEFTER.title);
        expectedTitles.add(THIRD_SERVICE_LEFTER.title);
        expectedTitles.add(FOURTH_SERVICE_LEFTER.title);
        expectedTitles.add(FIFTH_SERVICE_LEFTER.title);
        expectedTitles.add(SIXTH_SERVICE_LEFTER.title);
        expectedTitles.add(SEVENTH_SERVICE_LEFTER.title);
        expectedTitles.add(EIGHTH_SERVICE_LEFTER.title);

        assertEquals(serviceLeftListItems.size(), expectedTitles.size());
        Iterator<SelenideElement> serviceListItem = serviceLeftListItems.iterator();
        Iterator<String> itemText = expectedTitles.iterator();
        while (serviceListItem.hasNext() && itemText.hasNext()) {
            assertEquals(serviceListItem.next().getText(), itemText.next());
        }
    }
}
