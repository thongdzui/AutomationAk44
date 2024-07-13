package herokuapp;

import common.TestBase;
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
