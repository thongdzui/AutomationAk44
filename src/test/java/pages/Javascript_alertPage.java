package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class Javascript_alertPage {
    By JsAlert = By.xpath("//button[text()='Click for JS Alert']");
    By JsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    By JsPrompt = By.xpath("//button[.='Click for JS Prompt']");
    By JsResult = By.id("result");
    public void openUrl(){
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
    }
    public void clickJsAlert(){
        Browser.click(JsAlert);
    }
    public void clickJsConfirm()  {
        Browser.click(JsConfirm);
    }
    public void clickJsPrompt()  {
        Browser.click(JsPrompt);
    }
    public String getAlertText(){
        return Browser.getText(JsResult);
    }
    public void acceptAlert(){
        Browser.accpetAlert();
    }
    public void dismmisAlert(){
        Browser.dismissAlert();
    }
    public void sendKeyToAlert(){
        Browser.sendKeyToAlert("Ok");
    }

}
