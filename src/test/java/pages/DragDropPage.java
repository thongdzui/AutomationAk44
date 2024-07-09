package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class DragDropPage {
    By squareA = By.id("column-a");
    By squareB = By.id("column-b");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/drag_and_drop");
    }
    public void dragAtoB(){
        Browser.dragAndDrop(squareA,squareB);
    }
    public void dragBtoA(){
        Browser.dragAndDrop(squareB,squareA);
    }
    public String getSquareAContent(){
        return Browser.getText(By.id("column-a"));
    }
    public String getSquareBContent(){
        return Browser.getText(By.id("column-b"));
    }

}
