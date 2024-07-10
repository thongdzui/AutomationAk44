package herokuapp;

import common.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class DynamicLoading extends TestBase {
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    @Test
    void waitUntilProcessCompleted() throws InterruptedException {

        dynamicLoadingPage.open();
        dynamicLoadingPage.clickButtonStart();

        //ImplicitWait
        //Thread.sleep(10000);
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");
       //Explicit wait

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))).getText();
        // driver.findElement(By.cssSelector("#finish h4"))
        Assert.assertEquals(dynamicLoadingPage.getTextDynamicLoadingPage(),"Hello World!");
    }

   // @Test
    void captureScreeenShoot() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/screenshot-%s-%s.png", "process", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))).getText();
        Assert.assertEquals(result,"Hello World!");
        driver.quit();
    }
}
