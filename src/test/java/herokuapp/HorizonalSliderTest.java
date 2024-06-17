package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizonalSliderTest {
    @Test
    void verifySliderSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));
        actions.clickAndHold(pointer)
                .moveByOffset(pointer.getSize().width,0)
                .perform();

        Assert.assertEquals(driver.findElement(By.id("range")).getText(),"5");
    }

    @Test
    void infiniteScroll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        for (int i =0;i<4;i++){
            Thread.sleep(2000);
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
    }
    @Test
    void verifyKeyPressSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);

        actions.sendKeys("A").perform();

    }
}
