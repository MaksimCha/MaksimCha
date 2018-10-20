package hw4.ex1;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;

import static com.codeborne.selenide.Selenide.page;

public class ServicePageTest extends SelenideTestBase {

    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void simpleTest(){

    }
}
