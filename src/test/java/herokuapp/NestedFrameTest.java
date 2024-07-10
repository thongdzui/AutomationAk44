package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestedFramePage;

public class NestedFrameTest extends TestBase {
   NestedFramePage nestedFramePage = new NestedFramePage();


    @Test
    void verifyFrameContent(){
        nestedFramePage.open();
        nestedFramePage.switchToLeft();
        Assert.assertEquals(nestedFramePage.getTextFrameLeft(),"LEFT");

        nestedFramePage.switchToMiddle();
        Assert.assertEquals(nestedFramePage.getTextFrameMiddle(),"MIDDLE");

        nestedFramePage.switchToRight();
        Assert.assertEquals(nestedFramePage.getTextFrameRight(),"RIGHT");

        nestedFramePage.switchToBottom();
        Assert.assertEquals(nestedFramePage.getTextFrameBottom(),"BOTTOM");
    }

}
