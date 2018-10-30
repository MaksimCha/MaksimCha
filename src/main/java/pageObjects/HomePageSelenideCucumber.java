package pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenideCucumber {

    public HomePageSelenideCucumber(){
        page(this);
    }

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

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainTxt;

    private ElementsCollection testedImages = $$(By.cssSelector("div.benefit-icon > span"));

    private ElementsCollection imageTitles = $$(By.cssSelector("div.benefit > span"));

    private ElementsCollection serviceHeadListItems = $$(By.cssSelector(".m-l8 .dropdown-menu > li > a"));

    private ElementsCollection serviceLeftListItems = $$(By.cssSelector(".sidebar-menu .menu-title [class = 'sub'] li > a"));

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElementsButton;

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'user-table.html']")
    private SelenideElement userTableButton;

    //==============================methods==================================

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @And("I login as user \"Piter Chailovskii\"")
    public void loginAsPiter(){
        login("epam", "1234");
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    @When("I click on \"Service\" button in Header")
    public void headServiceButtonRealise() {
        serviceHeadButton.click();
    }

    @Step
    @When("I click Different Elements Page category")
    public void headServiceDifElRealise(){
        differentElementsButton.click();
    }

    @Step
    @And("I click on \"User Table\" button in Service dropdown")
    public void headServiceUserTableRealise(){
        userTableButton.click();
    }

    //==============================checks===================================

    @Step
    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), HOME_PAGE_TITLE.getTitle());
    }

    @Step
    @Then("The user name is (.+) value")
    public void checkLoginTitle(String title) {
        loginTitle.shouldHave(text(title));
    }

    @Step
    @And("4 pictures are displayed on the Home Page")
    public void checkIndexPageImages() {
        for (SelenideElement image : testedImages) {
            assertTrue(image.isDisplayed());
        }
    }

    @Step
    @And("4 texts are displayed under pictures respectively")
    public void checkImageTitles() {
//        ArrayList<String> expectedImageTitles = new ArrayList<>();
//        expectedImageTitles.add(FIRST_IMAGE_TITLE.title);
//        expectedImageTitles.add(SECOND_IMAGE_TITLE.title);
//        expectedImageTitles.add(THIRD_IMAGE_TITLE.title);
//        expectedImageTitles.add(FOURTH_IMAGE_TITLE.title);
//
//        assertEquals(imageTitles.size(), expectedImageTitles.size());
//        Iterator<SelenideElement> headerItem = imageTitles.iterator();
//        Iterator<String> itemText = expectedImageTitles.iterator();
//        while (headerItem.hasNext() && itemText.hasNext()) {
//            assertEquals(headerItem.next().getText(), itemText.next());
//        }
    }

    @Step
    @And("2 texts are displayed")
    public void checkMainHeaderText() {
        assertEquals(mainTitle.getText(), MAIN_HEADER_TITLE.getTitle());
        assertEquals(mainTxt.getText(), MAIN_HEADER_TEXT.getTitle());
    }

    @Step
    @Then("8 options are displayed in dropdown")
    public void checkHeadServiceDropDownContains(){
//        ArrayList<String> expectedTitles = new ArrayList<String>();
//        expectedTitles.add(FIRST_SERVICE_HEADER.title);
//        expectedTitles.add(SECOND_SERVICE_HEADER.title);
//        expectedTitles.add(THIRD_SERVICE_HEADER.title);
//        expectedTitles.add(FOURTH_SERVICE_HEADER.title);
//        expectedTitles.add(FIFTH_SERVICE_HEADER.title);
//        expectedTitles.add(SIXTH_SERVICE_HEADER.title);
//        expectedTitles.add(SEVENTH_SERVICE_HEADER.title);
//        expectedTitles.add(EIGHTH_SERVICE_HEADER.title);

//        assertEquals(serviceHeadListItems.size(), expectedTitles.size());
//        Iterator<SelenideElement> serviceListItem = serviceHeadListItems.iterator();
//        Iterator<String> itemText = expectedTitles.iterator();
//        while (serviceListItem.hasNext() && itemText.hasNext()) {
//            assertEquals(serviceListItem.next().getText(), itemText.next());
//        }
    }
}
