package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    /*

    Open browser
    Navigate to https://the-internet.herokuapp.com/dropdown
    Select "option 1"
    Validate "option 1" is selected
    //select[@id='dropdown']
    <select id="dropdown">
    <option value="" disabled="disabled">Please select an option</option>
    <option value="1" selected="selected">Option 1</option>
    <option value="2">Option 2</option>
    //select[@id='dropdown']
    </select>
     */
    @Test
    void verifyAbleSelectOption1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

       // Assert.assertTrue(driver.findElement(By.cssSelector("#dropdown option[value='1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());
        //.= viết tắt của Text
    }
    @Test
    void verifyAbleMultiSelectOpt(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        /*
        <select multiple="" id="fruits">
            <option value="banana">Banana</option>
            <option value="apple">Apple</option>
            <option value="orange">Orange</option>
            <option value="grape">Grape</option>
        </select>
        */
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText("Apple");
        select.selectByIndex(2);
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());


        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());
    }
    @Test
    void verifyAbleSelectCountry(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://ticketbox.vn/sign-in?ref=%2Fmy-tickets");
        // //div[contains(@class,'Countries__Placeholder')]
       driver.findElement(By.xpath("//*[contains(@class, 'Countries__Container')]")).click();
        //driver.findElement(By.xpath("//div[@class='Container__AlignItemsCenter-sc-17x1kk6-4 Countries__Placeholder-sc-1m20wpk-1 fYSkyu eBJwqZ']//*[name()='svg']")).click();
       driver.findElement(By.xpath("//*[.='Canada']")).click();
        //driver.findElement(By.xpath("//div[normalize-space()='Canada']")).click();

    }
}
