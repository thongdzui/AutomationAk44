package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {
    WebDriver driver;
    @Test
    void verifyImageInfo(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[1]")))
                .perform();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][1]//h5")).getText(),"name: user1");

    }
}
