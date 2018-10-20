package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

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

    //==============================================methods=========================================

    @Step("Login on site")
    @When("^I login as user (.+) with password (.+)$")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    //==============================================checks==========================================

    @Then("The browser title is Home Page$")
    public void checkTitle() {

    }

    @Then("^The user icon is displayed on the header$")
    public void checkUserIcon() {
        profileButton.shouldBe(visible);
    }
}
