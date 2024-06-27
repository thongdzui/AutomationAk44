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
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.Date;

public class Wait_explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
       // driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.get("https://automationfc.github.io/fluent-wait/");
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

    @Test
    public void Tc02_Explicit(){
       // driver.get("https://automationfc.github.io/fluent-wait/");
        //div[text(),'01:00:00']
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='01:01:00']")));
    }

    @Test
    public void TC_04_Not_Found_Only_Explicit_WebElement() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // không bị ảnh hưởng bời Implicit set mấy giây sẽ ra mấy giây
        System.out.println("1.1 - Start explicit wait: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("selenium"))));
        } catch (Exception e) {
            System.out.println("-----Exception of explicit----");
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("-----Exception of explicit----");
        }

        System.out.println("1.2 - End explicit wait: " + getDateTimeNow());

    }
    @Test
    public void TC_04_Not_Found_Only_Explicit_By() {
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // không bị ảnh hưởng bời Implicit set mấy giây sẽ ra mấy giây
        System.out.println("1.1 - Start explicit wait: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selenium")));
        } catch (Exception e) {
            System.out.println("-----Exception of explicit----");
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("-----Exception of explicit----");
        }

        System.out.println("1.2 - End explicit wait: " + getDateTimeNow());

    }
    @Test
    public void TC_02_Not_Found_Only_Implicit() {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println("1.1 - Start implicit wait: " + getDateTimeNow());
        try {
            driver.findElement(By.id("selenium"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("1.2 - End implicit wait: " + getDateTimeNow());

    }
    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
