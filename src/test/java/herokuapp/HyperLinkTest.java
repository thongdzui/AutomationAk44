package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HyperLinkTest {
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/status_codes
    Click on "200"
    Then "200 status code" page appear
    Click on "go here"
    Click on "301"
    Then "301 status code" page appear
    Click on "go here"
    Click on "404"
    Then "404 status code" page appear
    Click on "go here"
    Click on "500"
    Then "500 status code" page appear
Click on "go here"
     */
    @Test
    void verifyAbleHyperLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.linkText("200")).click();
       // Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p"))).getText().contains("This page returned a 200 status code."));
      //  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p")).getText().contains("This page returned a 200 status code."));
        //Assert.as

    }

}
