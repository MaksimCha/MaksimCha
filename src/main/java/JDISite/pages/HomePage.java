package JDISite.pages;

import JDISite.sections.Header;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import enums.Users;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/index.html", title = "Home Page")
public class HomePage extends WebPage {

    public Header header;

    @Step
    public void login(Users user) {
        header.profilePhoto.click();
        header.loginForm.loginAs(Users.PITER_CHALOVSKII);
    }
}
