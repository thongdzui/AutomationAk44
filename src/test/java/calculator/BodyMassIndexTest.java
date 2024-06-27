package calculator;


import common.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;
import supports.Browser;

public class BodyMassIndexTest extends TestBase {

    @BeforeClass
    @Parameters({"browser"})
    void openBrowser(String browser){
        Browser.lauchBrowser(browser);


    }
    @Test
    void TC01_Verify_result_BodyMassIndex(){
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();

        bodyMassIndexPage.openUrl();
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearMetricTab();
        bodyMassIndexPage.fillForm("30","male","170","65");
        bodyMassIndexPage.selectCalculateButton();


        Assert.assertEquals(bodyMassIndexPage.getResult(),"BMI = 22.5 kg/m2   (Normal)");

    }

    @AfterClass
    void closeBrowser(){
        Browser.quit();
    }

}
