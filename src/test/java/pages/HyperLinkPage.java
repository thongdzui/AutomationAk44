package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class HyperLinkPage {
    public void openUrl(){
        Browser.visit("https://the-internet.herokuapp.com/status_codes");
    }
    public void clickHere(){
        Browser.click(By.linkText("here"));
    }
    public void clickLink200(){
        Browser.click(By.linkText("200"));
    }
    public void clickLink301(){
        Browser.click(By.linkText("301"));
    }
    public void clickLink404(){
        Browser.click(By.linkText("404"));
    }
    public void clickLink500(){
        Browser.click(By.linkText("500"));
    }
    public String getCurrentURl(){
        return Browser.getCurrentUrl();
    }
}
