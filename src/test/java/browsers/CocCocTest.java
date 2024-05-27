package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Paths;



public class CocCocTest {
    String projectPath = System.getProperty("user.dir");

    @Test
    void openCocCoc(){




        // Set the ChromeDriver path
       // System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver");

        // Set up Chrome options
        // Specify the path
        String path = "/Applications/CocCoc.app/Contents/MacOS/CocCoc";
        ChromeOptions options = new ChromeOptions();
        options.setBinary(path);


        // Initialize the WebDriver with the specified options
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
       // driver.quit();

    }
}
