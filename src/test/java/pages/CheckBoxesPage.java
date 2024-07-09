package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class CheckBoxesPage {
    String checkboxLocator = "//*[@id='checkboxes']/input[%s]";
    public void openUrl(){
        Browser.visit("https://the-internet.herokuapp.com/checkboxes");
    }
    public void selectCheckbox(String checkboxNumber){
        Browser.check(getCheckboxByIndex(checkboxNumber));
    }
    public void deselectCheckbox(String checkboxNumber){
        Browser.uncheck(getCheckboxByIndex(checkboxNumber));
    }
    public boolean isCheckboxSelected(String checkboxNumber){
        return Browser.isSelected(getCheckboxByIndex(checkboxNumber));
    }
    private By getCheckboxByIndex(String index){
        return By.xpath(String.format(checkboxLocator, index));
    }

}
