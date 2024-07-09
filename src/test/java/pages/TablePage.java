package pages;

import herokuapp.Person;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

public class TablePage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/tables");
    }
//    private Person getListPersonInTable(){
//        List<WebElement> rows = Browser.
//    }
    public String getMaxDuePersonInTable1(){
        return "";
        //todo
    }
}
