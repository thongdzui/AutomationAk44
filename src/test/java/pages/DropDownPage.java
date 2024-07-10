package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownPage {
    By dropdown = By.id("dropdown");
    By multi_dropdown = By.id("fruits");
    By option_Apple = By.xpath("//option[.='Apple']");
    By option_Orange = By.xpath("//option[.='Orange']");
    By option_Banana = By.xpath("//option[.='Banana']");
    By option_Grape = By.xpath("//option[.='Grape']");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOption1(){
        Select select = new Select(Browser.getElement(dropdown));
        select.selectByVisibleText("Option 1");
    }
    public String getFirstSelectOption1(){
        Select select = new Select(Browser.getElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
    public void openMultiDropDown(){
        Browser.visit("https://output.jsbin.com/osebed/2");
    }
    public void selectMultiOption(){
        Select select = new Select(Browser.getElement(multi_dropdown));
        select.selectByVisibleText("Apple");
        select.selectByIndex(2);
    }
    public boolean verifyOptionApple(){
        return Browser.isSelected(option_Apple);
    }
    public boolean verifyOptionOrange(){
        return Browser.isSelected(option_Orange);
    }
    public boolean verifyOptionBanana(){
        return Browser.isSelected(option_Banana);
    }
    public boolean verifyOptionGrape(){
        return Browser.isSelected(option_Grape);
    }
    public void deselectAllOption(){
        Select select = new Select(Browser.getElement(multi_dropdown));
        select.deselectAll();
    }

}
