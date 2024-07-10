package pages;


import org.openqa.selenium.By;
import supports.Browser;

public class HoverPage {
    By hover_image1 = By.xpath("(//div[@class='figure'])[1]");
    By hover_image_result = By.xpath("//div[@class='figure'][1]//h5");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/hovers");
    }
    public void hoverAction(){
        Browser.hoverAction(hover_image1);
    }
    public String getTextHoverImage1(){
        return Browser.getText(hover_image_result);
    }
}
