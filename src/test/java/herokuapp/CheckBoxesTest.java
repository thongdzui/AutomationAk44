package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import supports.Browser;

public class CheckBoxesTest extends TestBase {
    /**
     *
     Open browser
     Navigate to https://the-internet.herokuapp.com/checkboxes
     Check on checkbox1
     Verify checkbox1 is checked
     Check on checkbox2
     Verify checkbox2 is checked
     */

    WebDriver driver;
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @Test
    void verifyAbleSelectACheckbox(){

        checkBoxesPage.openUrl();
        checkBoxesPage.selectCheckbox("1");

        Assert.assertTrue(checkBoxesPage.isCheckboxSelected("1"));


        checkBoxesPage.selectCheckbox("2");
        Assert.assertTrue(checkBoxesPage.isCheckboxSelected("2"));

    }
    @Test
    void verifyAbleUnSelectACheckbox(){

        checkBoxesPage.openUrl();

        checkBoxesPage.deselectCheckbox("1");

        Assert.assertFalse(checkBoxesPage.isCheckboxSelected("1"));

        checkBoxesPage.deselectCheckbox("2");
        Assert.assertFalse(checkBoxesPage.isCheckboxSelected("2"));

    }




}
