package JDISite;

import JDISite.pages.HomePage;
import JDISite.pages.MetalColorPage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;
    public static MetalColorPage metalColorPage;
}
