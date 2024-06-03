package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    /*

    1) Open browser
    2) Navigate to https://the-internet.herokuapp.com/login
    3) Fill in username with tomsmith
    4) Fill in the password with SuperSecretPassword!
    5) Click on Login button
    And the home page is appear
     */
    @Test
    void successfullyWeb(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        /*
        Tagname: input
        Attributes:
        type: text
        id: username
        name:username
        Text: n/a
        * */
        //driver.findElement(By.tagName("input")).sendKeys("tosmith");
       // driver.findElement(By.cssSelector("input")).sendKeys("tosmith");
        //driver.findElement(By.xpath("//input")).sendKeys("tosmith");

       // driver.findElement(By.cssSelector("[type=text]")).sendKeys("tosmith");
        // driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tosmith");
      //  driver.findElement(By.xpath("input[@type='text']")).sendKeys("tosmith");

        //driver.findElement(By.id("username")).sendKeys("tosmith");
        //driver.findElement(By.cssSelector("#username")).sendKeys("tosmith");
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tosmith");
       // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tosmith");


        //driver.findElement(By.name("username")).sendKeys("tosmith");
        //driver.findElement(By.cssSelector("[name=username]")).sendKeys("tosmith");

        //driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tosmith");
        // id >>name >> tagName >> css >> xpath
        driver.findElement(By.id("username")).sendKeys("tosmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // driver.findElement(By.className("radius")).click();
        //driver.findElement(By.tagName("button")).click();
       // driver.findElement(By.cssSelector("button.radius")).click();
        //driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //driver.findElement(By.xpath("//button[@class='radius']")).click();
        //driver.findElement(By.xpath("//*[@type='submit']")).click();
        //driver.findElement(By.xpath("//*[@class='radius']")).click();
    }

    @Test
    void loginWithInvalidUser(){
        /*
        1) Open browser
        2) Navigate to https://the-internet.herokuapp.com/login
        3) Fill in username with tomsmith
        4) Fill in the password with SuperSecretPassword!
                5) Click on Login button
        And the home page is appear*/

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tosmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       // driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("button[class=radius]")).click();
       // Assert.assertEquals(driver.findElement(By.className("success")).getText().contains("Your username is invalid"));

      //  Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));

    }
    @Test
    void basicAuthentication(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //div[@class='example']//p
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']//p")).getText().contains("Congratulations!"));

    }


}
