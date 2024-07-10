package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class DynamicLoadingPage {
    By button_click = By.xpath("//button[.='Start']");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    public void clickButtonStart(){
        Browser.click(button_click);
    }
    public String getTextDynamicLoadingPage(){
        Browser.waitForElementVisible("//div[@id='finish']/h4");
        return Browser.getText(By.xpath("//div[@id='finish']/h4"));
    }
}
