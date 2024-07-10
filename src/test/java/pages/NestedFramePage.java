package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class NestedFramePage {
    String frame_top = "frame-top";
    String frame_left = "frame-left";
    By frame_locator = By.xpath("/html/body");
    By frame_locator_middle = By.id("content");
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/nested_frames");
    }
    public void switchToLeft(){
        Browser.switchToFrame(frame_top);
        Browser.switchToFrame(frame_left);
    }
    public void switchToMiddle(){
        Browser.switchToParent();
        Browser.switchToFrame("frame-middle");
    }
    public void switchToRight(){
        Browser.switchToParent();
        Browser.switchToFrame("frame-right");
    }
    public void switchToBottom(){
        Browser.switchToParent();
        Browser.switchToParent();
        Browser.switchToFrame("frame-bottom");
    }
    public String getTextFrameLeft(){
        return Browser.getText(frame_locator);
    }
    public String getTextFrameMiddle(){
        return Browser.getText(frame_locator_middle);
    }
    public String getTextFrameRight(){
        return Browser.getText(frame_locator);
    }
    public String getTextFrameBottom(){
        return Browser.getText(frame_locator);
    }
}
