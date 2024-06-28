package pages;


import org.openqa.selenium.By;
import supports.Browser;

public class FormAuthenticationPage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/login");

    }
    public void login(String username, String password){
        Browser.sendKeys(By.id("username"),username);
        Browser.sendKeys(By.id("password"),password);
        Browser.click(By.cssSelector("button[class=radius]"));

    }
    public String getMessage(String messageType){
        return Browser.getText(By.className(messageType));
    }
}
