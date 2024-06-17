package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTest {
    WebDriver driver;
    @BeforeMethod
    void SetUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

    }
    @Test
    void verifyFrameContent(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals(driver.findElement(By.xpath("//html/body")).getText(),"LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(driver.findElement(By.id("content")).getText(),"MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(driver.findElement(By.xpath("//html/body")).getText(),"RIGHT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertEquals(driver.findElement(By.xpath("//html/body")).getText(),"BOTTOM");
    }
    @AfterMethod
    void TearDown(){
        driver.quit();
    }
}
