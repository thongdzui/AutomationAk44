package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Javascript_alerts {
    WebDriver driver;
    @BeforeClass
    void SetUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    void clickOnJSAlertSuccessfully(){

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
        //"//button[.='Click for JS Alert']"

    }
    @Test
    void acceptOnJSConfirmSuccessfully(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
        ////button[.='Click for JS Confirm']

    }
    @Test
    void cancelOnJSConfirmSuccessfully(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");
        ////button[.='Click for JS Confirm']

    }
    @Test
    void clickOnJSPromptSuccessfully(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Ok");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: Ok");
        ////button[.='Click for JS Confirm']

    }
    @AfterClass
    void TearDown(){
        driver.quit();
    }
}
