package JDISite.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import entities.MetalColorsPageData;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class Result extends Section {

    @FindBy(css = ".info-panel-body-result")
    public TextArea result;

    public void checkResult(MetalColorsPageData dataSet) {
        int sumOddsEven = 0;
        for (String sum : dataSet.summary) {
            sumOddsEven += Integer.parseInt(sum);
        }

        String elements = String.join(", ", dataSet.elements);

        String vegetables = String.join(", ", dataSet.vegetables);

        String expected =
                "Summary: " + sumOddsEven +
                        "\nElements: " + elements +
                        "\nColor: " + dataSet.color +
                        "\nMetal: " + dataSet.metals +
                        "\nVegetables: " + vegetables;

        assertEquals(result.getText(), expected);
    }
}
