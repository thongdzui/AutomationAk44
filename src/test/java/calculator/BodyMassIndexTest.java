package calculator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BodyMassIndexPage;
import supports.Browser;

public class BodyMassIndexTest {
    WebDriver driver;
    @BeforeMethod
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

    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()) Browser.takeScreenShot(iTestResult.getMethod().getMethodName());
        Browser.quit();
    }

}
