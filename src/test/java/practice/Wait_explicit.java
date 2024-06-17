package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Wait_explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.manage().window().maximize();
    }
    @Test
    public void Tc01_Date_Picker(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement textToday = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
        Assert.assertEquals(textToday.getText(),"No Selected Dates to display.");

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='1']")));
        driver.findElement(By.xpath("//a[text()='1']")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']")));

        //span[@id='ctl00_ContentPlaceholder1_Label1']
        Assert.assertEquals(driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText(),"Saturday, June 1, 2024");

        //Assert.assertTrue(driver.findElement(By.xpath("//td[@class='rcSelected']/a[.='1']")).isDisplayed());
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']/a[.='1']")));
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='rcSelected']/a[text()='1']")).isDisplayed());




    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
