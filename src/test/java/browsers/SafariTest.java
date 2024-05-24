package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafariTest {
    @Test
    void openSafari(){

        WebDriver driver = new SafariDriver();
        //WebDriver driver = new SafariDriver();
        driver.get("https://www.selenium.dev/");
        driver.navigate().to("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();

    }
}
