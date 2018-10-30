package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static enums.Titles.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenium {

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

    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> headerItems;

    @FindBy(css = "div.benefit-icon > span")
    private List<WebElement> testedImages;

    @FindBy(css = "div.benefit > span")
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

    public void checkHeaderItemText() {
        ArrayList<String> expectedTitles = new ArrayList<>();
        expectedTitles.add(FIRST_HEADER_ITEM.getTitle());
        expectedTitles.add(SECOND_HEADER_ITEM.getTitle());
        expectedTitles.add(THIRD_HEADER_ITEM.getTitle());
        expectedTitles.add(FOURTH_HEADER_ITEM.getTitle());

        assertEquals(headerItems.size(), expectedTitles.size());
        Iterator<WebElement> headerItem = headerItems.iterator();
        Iterator<String> itemText = expectedTitles.iterator();
        while (headerItem.hasNext() && itemText.hasNext()) {
            assertEquals(headerItem.next().getText(), itemText.next());
        }
    }

    public void checkIndexPageImages() {
        for (WebElement image : testedImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkImageTitles() {
        ArrayList<String> expectedImageTitles = new ArrayList<>();
        expectedImageTitles.add(FIRST_IMAGE_TITLE.getTitle());
        expectedImageTitles.add(SECOND_IMAGE_TITLE.getTitle());
        expectedImageTitles.add(THIRD_IMAGE_TITLE.getTitle());
        expectedImageTitles.add(FOURTH_IMAGE_TITLE.getTitle());

        assertEquals(imageTitles.size(), expectedImageTitles.size());
        Iterator<WebElement> headerItem = imageTitles.iterator();
        Iterator<String> itemText = expectedImageTitles.iterator();
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
