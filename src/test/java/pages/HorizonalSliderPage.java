package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class HorizonalSliderPage {

    By pointer = By.cssSelector(".sliderContainer input");

    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/horizontal_slider");
    }
    public void horizontalSliderToLevel(int level) throws InterruptedException {

        Browser.horizonalSlider(Browser.getElementWidth(pointer)*level/5, pointer);

    }
    public String getLevel() throws InterruptedException {
        Thread.sleep(15000);
        return Browser.getText(By.id("range"));
    }

}
