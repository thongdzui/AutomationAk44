package herokuapp;

import common.TestBase;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HyperLinkPage;


public class HyperLinkTest extends TestBase {
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/status_codes
    Click on "200"
    Then "200 status code" page appear
    Click on "go here"
    Click on "301"
    Then "301 status code" page appear
    Click on "go here"
    Click on "404"
    Then "404 status code" page appear
    Click on "go here"
    Click on "500"
    Then "500 status code" page appear
Click on "go here"
     */
    HyperLinkPage hyperLinkPage = new HyperLinkPage();
    @Test
    void verifyAbleHyperLink() {
        hyperLinkPage.openUrl();
        hyperLinkPage.clickLink200();



        Assert.assertEquals(hyperLinkPage.getCurrentURl(),"https://the-internet.herokuapp.com/status_codes/200");
        hyperLinkPage.clickHere();


        hyperLinkPage.clickLink301();
        Assert.assertEquals(hyperLinkPage.getCurrentURl(),"https://the-internet.herokuapp.com/status_codes/301");
        hyperLinkPage.clickHere();

        hyperLinkPage.clickLink404();
        Assert.assertEquals(hyperLinkPage.getCurrentURl(),"https://the-internet.herokuapp.com/status_codes/404");
        hyperLinkPage.clickHere();

        hyperLinkPage.clickLink500();
        Assert.assertEquals(hyperLinkPage.getCurrentURl(),"https://the-internet.herokuapp.com/status_codes/500");
        hyperLinkPage.clickHere();

    }

}
