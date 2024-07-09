package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

public class ContextMenuPage {
    By belowBox = By.id("hot-spot");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/context_menu");
    }
    public void contextMenu(){
        Browser.contextMenu(belowBox);
    }
}
