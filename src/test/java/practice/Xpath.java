package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Xpath {
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/");

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    void TC01_Login_Empty_Email_Password(){
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.name("send")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");



    }
    @Test
    void TC02_Login_Invalid_Email(){
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("123@345.6666");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.name("send")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");


    }
    @Test
    void TC03_Login_Invalid_Password(){
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("automation@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.name("send")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }
    @Test
    void TC04_Login_Incorrect_Password(){
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("automation@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.name("send")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");

    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
