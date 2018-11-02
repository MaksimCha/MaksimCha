package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
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

    @FindBy(css = "[id = 'user-table'] td")
    private List<SelenideElement> userTable;
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
    public void checkDescriptionTexts(){
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
    public void checkUserTable(List<List<String>> table){
        table.remove(0);
        Iterator<SelenideElement> element = userTable.iterator();
        for (List<String> row : table) {
            if(element.hasNext()){
                element.next().shouldBe(text(row.get(0)));
                element.next();
                element.next().shouldBe(text(row.get(1)));
                element.next().shouldBe(text(row.get(2)));
            }
        }
    }
}
