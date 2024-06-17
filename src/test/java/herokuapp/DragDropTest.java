package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest {
    @Test
    void verifyDragDropSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        WebElement squareA = driver.findElement(By.id("column-a"));
        WebElement squareB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(squareA,squareB).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("#column-a header")).getText(),"B");
    }
}
