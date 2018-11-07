package JDISite;

import JDISite.pages.HomePage;
import JDISite.pages.MetalColorPage;
import JDISite.sections.LoginForm;
import JDISite.sections.MetalColorSubmitForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.FormData;
import entities.User;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertEquals;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static MetalColorPage metalColorPage;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    public static MetalColorSubmitForm metalColorSubmitForm;

    @FindBy(css = ".info-panel-body-result")
    public static TextArea result;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User(Users.PITER_CHALOVSKII));
    }

    @Step
    public static void fillForm(FormData dataSet) {
        // TODO This code do not following one of the 'OOP rule'.
        // TODO In this particular method, you are working with 'metalColorSubmitForm' only,
        // TODO so you have to place it in the appropriate class.
        metalColorSubmitForm.vegetables.select("vegetables");
        for (String vegetable : dataSet.vegetables) {
            metalColorSubmitForm.vegetables.select(vegetable);
        }
        metalColorSubmitForm.colors.select(dataSet.color);
        metalColorSubmitForm.metals.select(dataSet.metals);
        for (String element : dataSet.elements) {
            metalColorSubmitForm.elementsCheckBoxes.select(element);
        }
        metalColorSubmitForm.oddsRadioButtons.select(dataSet.summary.get(0));
        metalColorSubmitForm.evenRadioButtons.select(dataSet.summary.get(1));
    }

    @Step
    public static void submitButtonClick() {
        metalColorSubmitForm.submitButton.click();
    }

    @Step
    public static void checkResult(FormData dataSet) {
        // TODO Take a look on Strings.join
        int sumOddsEven = 0;
        for (String sum : dataSet.summary) {
            sumOddsEven += Integer.parseInt(sum);
        }

        StringBuilder elements = new StringBuilder();
        String delim = "";
        for (String element : dataSet.elements) {
            elements.append(delim).append(element);
            delim = ", ";
        }

        StringBuilder vegetables = new StringBuilder();
        String delimeter = "";
        for (String vegetable : dataSet.vegetables) {
            vegetables.append(delimeter).append(vegetable);
            delimeter = ", ";
        }

        String expected =
                "Summary: " + sumOddsEven +
                        "\nElements: " + elements +
                        "\nColor: " + dataSet.color +
                        "\nMetal: " + dataSet.metals +
                        "\nVegetables: " + vegetables;

        assertEquals(result.getText(), expected);
    }

}
