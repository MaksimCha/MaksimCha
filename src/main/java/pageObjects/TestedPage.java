package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestedPage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = "div.profile-photo > span")
    private WebElement loginTitle;

    @FindAll({@FindBy(css = ".m-l8 > li > a")})
    private List<WebElement> headerItems;

    @FindAll({@FindBy(css = "div.benefit-icon > span")})
    private List<WebElement> testedImages;

    @FindAll({@FindBy(css = "div.benefit > span")})
    private List<WebElement> imageTitles;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainTxt;

    @FindBy(css = "iframe")
    private WebElement mainFrame;

    @FindBy(css = "h3.text-center > a")
    private WebElement subHeader;

    @FindBy(css = "div.mCustomScrollBox")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //==============================================methods=========================================

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void switchToMainFrame(WebDriver driver) {
        driver.switchTo().frame(mainFrame);
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    //==============================================checks==========================================

    public void checkTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void checkLoginTitle(String title) {
        assertEquals(loginTitle.getText(), title);
    }

    public void checkHeaderItemText(List<String> itemTexts) {
        assertEquals(headerItems.size(), itemTexts.size());
        Iterator<WebElement> headerItem = headerItems.iterator();
        Iterator<String> itemText = itemTexts.iterator();
        while (headerItem.hasNext() && itemText.hasNext()) {
            assertEquals(headerItem.next().getText(), itemText.next());
        }
    }

    public void checkIndexPageImages() {
        for (WebElement image : testedImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkImageTitles(List<String> titles) {
        assertEquals(imageTitles.size(), titles.size());
        Iterator<WebElement> headerItem = imageTitles.iterator();
        Iterator<String> itemText = titles.iterator();
        while (headerItem.hasNext() && itemText.hasNext()) {
            assertEquals(headerItem.next().getText(), itemText.next());
        }
    }

    public void checkMainHeaderText(String Title, String Text) {
        assertEquals(mainTitle.getText(), Title);
        assertEquals(mainTxt.getText(), Text);
    }

    public void checkFrameDisplaying() {
        assertTrue(mainFrame.isDisplayed());
    }

    public void checkFrameLogo(WebDriver driver) {
        WebElement frameLogo = driver.findElement(By.cssSelector("div.epam-logo > a > img"));
        assertTrue(frameLogo.isDisplayed());
    }

    public void checkSubHeaderDisplaying() {
        assertTrue(subHeader.isDisplayed());
    }

    public void checkSubHeaderLink(String link) {
        assertEquals(subHeader.getAttribute("href"), link);
    }

    public void checkLeftSectionDisplaying() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterDisplaying() {
        assertTrue(footer.isDisplayed());
    }
}
