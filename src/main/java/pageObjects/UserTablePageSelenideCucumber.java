package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataTableRows.UserTableRow;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.USER_TABLE_PAGE_TITLE;
import static org.testng.Assert.assertEquals;

public class UserTablePageSelenideCucumber {

    public UserTablePageSelenideCucumber(){
        page(this);
    }

    private List<UserTableRow> rows;
    @FindBy(css = ".main-content-hg > table > tbody > tr > td > select")
    private ElementsCollection numberTypeDropDowns;

    @FindBy(css = ".main-content-hg > table > tbody > tr > td [href = '']")
    private ElementsCollection userNames;

    @FindBy(css = ".main-content-hg > table > tbody > tr > td > img")
    private ElementsCollection descriptionImages;

    @FindBy(css = ".user-descr > span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = ".user-descr > input")
    private ElementsCollection checkBoxes;
    //==============================methods==================================

    //==============================checks===================================

    @Step
    @Then("\"User Table\" page is opened")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), USER_TABLE_PAGE_TITLE.getTitle());
    }

    @Step
    @And("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkNumberTypeDropDowns(){
        for (SelenideElement numberType: numberTypeDropDowns) {
            numberType.shouldBe(visible);
        }
    }

    @Step
    @And("6 User names are displayed on Users Table on User Table Page")
    public void checkUserNames(){
        for (SelenideElement userName: userNames) {
            userName.shouldBe(visible);
        }
    }

    @Step
    @And("6 Description images are displayed on Users Table on User Table Page")
    public void checkdescriptionImages(){
        for (SelenideElement descriptionImage: descriptionImages) {
            descriptionImage.shouldBe(visible);
        }
    }

    @Step
    @And("6 Description texts under images are displayed on Users Table on User Table Page")
    public void checkdescriptionTexts(){
        for (SelenideElement descriptionText: descriptionTexts) {
            descriptionText.shouldBe(visible);
        }
    }

    @Step
    @And("6 checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckBoxes(){
        for (SelenideElement checkBox: checkBoxes) {
            checkBox.shouldBe(visible);
        }
    }

    @Step
    @And("^User table contains following values$")
    public void checkUserTable(List<UserTableRow> rows){
        this.rows = rows;
        for (UserTableRow row: rows) {
            userNames.get(row.getNumber()).shouldBe(text(row.getUser()));
            descriptionTexts.get(row.getNumber()).shouldBe(text(row.getDescription()));
        }
    }
}
