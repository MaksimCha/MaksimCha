package pageObjects;


import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ImageTitles;
import enums.ServiceItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Links.HOME_PAGE_LINK;
import static enums.ServiceItems.getServiceItemTitles;
import static enums.Titles.*;
import static enums.Users.PITER_CHALOVSKII;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageCucumber {

    public HomePageCucumber() {
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
    private SelenideElement serviceButton;

    @FindBy(css = ".m-l8 [href = 'dates.html']")
    private SelenideElement datesButton;

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElementsButton;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainTxt;

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'user-table.html']")
    private SelenideElement userTableButton;

    @FindBy(css = "div.benefit > span")
    private List<SelenideElement> imageTitles;

    @FindBy(css = "div.benefit-icon > span")
    private List<SelenideElement> testedImages;

    @FindBy(css = ".m-l8 .dropdown-menu > li > a")
    private List<SelenideElement> serviceItems;

    @FindBy(css = ".sidebar-menu .menu-title [class = 'sub'] li > a")
    private List<SelenideElement> leftPannelServiceItems;

    //==============================methods==================================

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open(HOME_PAGE_LINK.getLink());
    }

    @Step
    @And("I login as user \"Piter Chailovskii\"")
    public void loginAsPiter() {
        login(PITER_CHALOVSKII.name, PITER_CHALOVSKII.password);
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
    public void serviceButtonClick() {
        serviceButton.click();
    }

    @Step
    @When("I click Different Elements Page category")
    public void differentElementsButtonClick() {
        differentElementsButton.click();
    }

    @Step
    @And("I click on \"User Table\" button in Service dropdown")
    public void userTableButtonClick() {
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
        assertEquals(imageTitles.size(), ImageTitles.values().length);
        ArrayList<String> actualTitles = new ArrayList<>();
        for (SelenideElement item : imageTitles) {
            actualTitles.add(item.getText().toUpperCase());
        }
        assertTrue(actualTitles.containsAll(ImageTitles.getImageTitles()));
    }

    @Step
    @And("2 texts are displayed")
    public void checkMainHeaderText() {
        assertEquals(mainTitle.getText(), MAIN_HEADER_TITLE.getTitle());
        assertEquals(mainTxt.getText(), MAIN_HEADER_TEXT.getTitle());
    }

    @Step
    @Then("8 options are displayed in dropdown")
    public void checkServiceDropDownContains() {
        assertEquals(serviceItems.size(), ServiceItems.values().length);
        ArrayList<String> actualTitles = new ArrayList<>();
        for (SelenideElement item : serviceItems) {
            actualTitles.add(item.getText().toUpperCase());
        }
        assertTrue(actualTitles.containsAll(getServiceItemTitles()));
    }
}
