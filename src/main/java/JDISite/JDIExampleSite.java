package JDISite;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import JDISite.pages.HomePage;
import JDISite.pages.MetalColorPage;
import JDISite.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static MetalColorPage metalColorPage;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User(Users.PITER_CHALOVSKII));
    }
}
