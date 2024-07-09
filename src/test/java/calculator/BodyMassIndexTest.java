package calculator;


import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;
import supports.Browser;

public class BodyMassIndexTest extends TestBase {

    @BeforeClass
    @Parameters({"browser"})
    void openBrowser(String browser){
        Browser.launchBrowser(browser);


    }
    @Test
    void TC01_Verify_result_BodyMassIndex(){
        // Arrange
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();

        bodyMassIndexPage.openUrl();
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearMetricTab();
        bodyMassIndexPage.fillForm("34","male","170","65");
        bodyMassIndexPage.selectCalculateButton();

        // Act
        var actual = bodyMassIndexPage.getResult();

        // Assert
        Assert.assertEquals(actual,"BMI = 22.8 kg/m2   (Normal)");
    }

}
