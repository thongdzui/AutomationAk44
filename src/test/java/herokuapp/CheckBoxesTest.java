package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest {
    /**
     *
     Open browser
     Navigate to https://the-internet.herokuapp.com/checkboxes
     Check on checkbox1
     Verify checkbox1 is checked
     Check on checkbox2
     Verify checkbox2 is checked
     */

    @Test
    void verifyAbleSelectACheckbox(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // #checkboxes input:nth-child(1)
        // //input[@type='checkbox']/../input[1]

        check(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).isSelected());


        check(driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).isSelected());
        //form[@id='checkboxes']//input[2]//@checked
        driver.quit();
    }
    @Test
    void verifyAbleUnSelectACheckbox(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        uncheck(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).isSelected());


        uncheck(driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).isSelected());

        driver.quit();
    }
    public static void check(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }
    public static void uncheck(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }

}
