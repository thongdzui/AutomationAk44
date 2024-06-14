package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;
    /*

    1) Open browser
    2) Navigate to https://the-internet.herokuapp.com/login
    3) Fill in username with tomsmith
    4) Fill in the password with SuperSecretPassword!
    5) Click on Login button
    And the home page is appear
     */
//    @Test
//    void successfullyWeb(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/login");
//        /*
//        Tagname: input
//        Attributes:
//        type: text
//        id: username
//        name:username
//        Text: n/a
//        * */
//        //driver.findElement(By.tagName("input")).sendKeys("tosmith");
//       // driver.findElement(By.cssSelector("input")).sendKeys("tosmith");
//        //driver.findElement(By.xpath("//input")).sendKeys("tosmith");
//
//       // driver.findElement(By.cssSelector("[type=text]")).sendKeys("tosmith");
//        // driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tosmith");
//      //  driver.findElement(By.xpath("input[@type='text']")).sendKeys("tosmith");
//
//        //driver.findElement(By.id("username")).sendKeys("tosmith");
//        //driver.findElement(By.cssSelector("#username")).sendKeys("tosmith");
//        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tosmith");
//       // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tosmith");
//
//
//        //driver.findElement(By.name("username")).sendKeys("tosmith");
//        //driver.findElement(By.cssSelector("[name=username]")).sendKeys("tosmith");
//
//        //driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tosmith");
//        // id >>name >> tagName >> css >> xpath
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//
//        // driver.findElement(By.className("radius")).click();
//        //driver.findElement(By.tagName("button")).click();
//       // driver.findElement(By.cssSelector("button.radius")).click();
//        //driver.findElement(By.cssSelector("[type=submit]")).click();
//        driver.findElement(By.cssSelector("button[type=submit]")).click();
//        //driver.findElement(By.xpath("//button[@type='submit']")).click();
//        //driver.findElement(By.xpath("//button[@class='radius']")).click();
//        //driver.findElement(By.xpath("//*[@type='submit']")).click();
//        //driver.findElement(By.xpath("//*[@class='radius']")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
//        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
//        Assert.assertEquals(driver.findElement(By.cssSelector("#content h4")).getText(),"Welcome to the Secure Area. When you are done click logout below.");
//
//    }

    @BeforeMethod
    void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

    }
    @DataProvider
    Object[][] credentialData(){
        return new Object[][]{
                {"tomsmith1","SuperSecretPassword!","https://the-internet.herokuapp.com/login","error","Your username is invalid"},
                {"tomsmith","SuperSecretPassword!111","https://the-internet.herokuapp.com/login","error","Your password is invalid"},
                {"tomsmith","SuperSecretPassword!","https://the-internet.herokuapp.com/secure","success","You logged into a secure area!"},

        };
    }
    @Test(dataProvider = "credentialData")
    void loginWithInvalidUser(String username, String password,String expectedURL,String expectedMessageStyle, String expectedMessage){
        /*
        1) Open browser
        2) Navigate to https://the-internet.herokuapp.com/login
        3) Fill in username with tomsmith
        4) Fill in the password with SuperSecretPassword!
                5) Click on Login button
        And the home page is appear*/

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
       // driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("button[class=radius]")).click();
       //Assert.assertEquals(driver.findElement(By.className("success")).getText().contains("Your username is invalid"));

        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
       Assert.assertTrue(driver.findElement(By.className(expectedMessageStyle)).getText().contains(expectedMessage));
       driver.quit();

    }
    @Test
    void basicAuthentication(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //div[@class='example']//p
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']//p")).getText().contains("Congratulations!"));

    }
    @AfterMethod
    void closeBrowser(){
        driver.quit();
    }


}
