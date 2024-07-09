package herokuapp;

import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HorizonalSliderPage;
import supports.Browser;

public class HorizonalSliderTest  {
    HorizonalSliderPage horizonalSliderPage;
    @BeforeClass
    void launchBrowser(){
        Browser.launchBrowser("chrome");
    }
    @Test
    void TC_01_Horizotal_Slider() throws InterruptedException {
        horizonalSliderPage = new HorizonalSliderPage();
        horizonalSliderPage.open();
        horizonalSliderPage.horizontalSliderToLevel(2);
        Assert.assertEquals(horizonalSliderPage.getLevel(),"4.5");
    }



}
