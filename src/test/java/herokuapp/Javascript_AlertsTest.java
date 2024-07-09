package herokuapp;

import common.TestBase;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.Javascript_alertPage;

public class Javascript_AlertsTest extends TestBase {
    Javascript_alertPage javascript_alertPage = new Javascript_alertPage();

   @Test
    void Tc01_clickOnJSAlertSuccessfully(){

        javascript_alertPage.openUrl();
        javascript_alertPage.clickJsAlert();
        javascript_alertPage.acceptAlert();

        Assert.assertEquals(javascript_alertPage.getAlertText(),"You successfully clicked an alert");
        //"//button[.='Click for JS Alert']"

    }
    @Test
    void Tc02_acceptOnJSConfirmSuccessfully()  {
        //javascript_alertPage.openUrl();
        javascript_alertPage.clickJsConfirm();
        javascript_alertPage.acceptAlert();

        Assert.assertEquals(javascript_alertPage.getAlertText(),"You clicked: Ok");
        ////button[.='Click for JS Confirm']

    }
    @Test
    void Tc03_cancelOnJSConfirmSuccessfully()  {
        javascript_alertPage.clickJsConfirm();
        javascript_alertPage.dismmisAlert();

        Assert.assertEquals(javascript_alertPage.getAlertText(),"You clicked: Cancel");
        ////button[.='Click for JS Confirm']

    }
    @Test
    void Tc04_clickOnJSPromptSuccessfully() {
        javascript_alertPage.clickJsPrompt();
        javascript_alertPage.sendKeyToAlert();
        javascript_alertPage.acceptAlert();

        Assert.assertEquals(javascript_alertPage.getAlertText(),"You entered: Ok");
        ////button[.='Click for JS Confirm']

    }

}
