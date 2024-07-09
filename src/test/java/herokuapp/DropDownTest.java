package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragDropPage;
import pages.DropDownPage;

public class DropDownTest extends TestBase {
    DropDownPage dropDownPage = new DropDownPage();
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
    void TC01_verifyAbleSelectOption1(){
        dropDownPage.open();
        dropDownPage.selectOption1();



       // Assert.assertTrue(driver.findElement(By.cssSelector("#dropdown option[value='1']")).isSelected());
       // Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());
        //.= viết tắt của Text
        Assert.assertEquals(dropDownPage.getFirstSelectOption1(),"Option 1");
    }
    @Test
    void TC02_verifyAbleMultiSelectOpt(){

        dropDownPage.openMultiDropDown();
        /*
        <select multiple="" id="fruits">
            <option value="banana">Banana</option>
            <option value="apple">Apple</option>
            <option value="orange">Orange</option>
            <option value="grape">Grape</option>
        </select>
        */
        dropDownPage.selectMultiOption();
        Assert.assertTrue(dropDownPage.verifyOptionApple());
        Assert.assertTrue(dropDownPage.verifyOptionOrange());


        dropDownPage.deselectAllOption();
        Assert.assertFalse(dropDownPage.verifyOptionBanana());
        Assert.assertFalse(dropDownPage.verifyOptionApple());
        Assert.assertFalse(dropDownPage.verifyOptionOrange());
        Assert.assertFalse(dropDownPage.verifyOptionGrape());
    }
   // @Test
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
