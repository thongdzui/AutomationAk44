package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

//selenium owner method
public class Browser {
    private static WebDriver driver;
    public static void lauchBrowser(String name){
        switch (name){
            case "chrome":{
                driver =  new ChromeDriver();
                break;
            }
            case "firefox": {
                driver =  new FirefoxDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }
    public static void visit(String url){
        driver.get(url);
    }
    public static void click(By locator){
        driver.findElement(locator).click();
    }
    public static void sendKeys(By locator, CharSequence... keyToSend){
        driver.findElement(locator).sendKeys(keyToSend);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public static void check(By locator){
        if(!driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static void uncheck(By locator){
        if(driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static void takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
