package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;
import supports.Browser;

public class DragDropTest extends TestBase {
    DragDropPage dragDropPage;
    @BeforeMethod
    void openDragDropPage(){
        dragDropPage = new DragDropPage();
        dragDropPage.open();

    }
    @Test
    void verifyDragADropBSuccessfully(){
        dragDropPage.dragAtoB();
        Assert.assertEquals(dragDropPage.getSquareAContent(),"B");
        Assert.assertEquals(dragDropPage.getSquareBContent(),"A");

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//
//        Actions actions = new Actions(driver);
//
//        WebElement squareA = driver.findElement(By.id("column-a"));
//        WebElement squareB = driver.findElement(By.id("column-b"));
//        actions.dragAndDrop(squareA,squareB).perform();
//        Assert.assertEquals(driver.findElement(By.cssSelector("#column-a header")).getText(),"B");
    }
    @Test
    void verifyDragBDropASuccessfully(){
        dragDropPage.dragBtoA();
        Assert.assertEquals(dragDropPage.getSquareAContent(),"B");
        Assert.assertEquals(dragDropPage.getSquareBContent(),"A");

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//
//        Actions actions = new Actions(driver);
//
//        WebElement squareA = driver.findElement(By.id("column-a"));
//        WebElement squareB = driver.findElement(By.id("column-b"));
//        actions.dragAndDrop(squareA,squareB).perform();
//        Assert.assertEquals(driver.findElement(By.cssSelector("#column-a header")).getText(),"B");
    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
