package JDISite.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;
}
