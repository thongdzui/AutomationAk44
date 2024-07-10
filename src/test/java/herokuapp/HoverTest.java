package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends TestBase {

    HoverPage hoverPage = new HoverPage();
    @Test
    void verifyImageInfo(){
        hoverPage.open();
        hoverPage.hoverAction();


        Assert.assertEquals(hoverPage.getTextHoverImage1(),"name: user1");

    }
}
