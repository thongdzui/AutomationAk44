package herokuapp;


import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FormAuthenticationPage;
import supports.Browser;

public class FormAuthenticationTest extends TestBase {

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
        Browser.launchBrowser(browser);

    }
    @DataProvider
    Object[][] credentialData(){
        return new Object[][]{
                {"tomsmith1","SuperSecretPassword!","https://the-internet.herokuapp.com/login","error","Your username is invalid"},
                {"tomsmith","SuperSecretPassword!111","https://the-internet.herokuapp.com/login","error","Your password is invalid"},
                {"tomsmith","SuperSecretPassword!","https://the-internet.herokuapp.com/secure","success","You logged into a secure area!"},

        };
    }

    @Test(dataProvider = "credentialData")
    public void loginTest(String username, String password, String expectedURL, String expectedMessageStyle, String expectedMessage){
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login(username,password);
        Assert.assertEquals(Browser.getCurrentUrl(),expectedURL);
        Assert.assertTrue(formAuthenticationPage.getMessage(expectedMessageStyle).contains(expectedMessage));



    }
}
