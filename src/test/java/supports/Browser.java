package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

//selenium owner method
public class Browser {
    private static WebDriver driver;
    private static int MAX_TIME_OUT_SECOND = 30;
    public static WebDriverWait wait;
    public static Actions actions;
    public static void launchBrowser(String name){
        switch (name){
            case "chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME_OUT_SECOND));
        actions = new Actions(driver);
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
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    public static List<WebElement> getElementList(By locator){
        return driver.findElements(locator);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public static By getByXpath(String locator){
        return By.xpath(locator);
    }
    public static void check(By locator){
        if(!driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
    public static void uncheck(By locator){
        if(driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();

    }
    public static void dragAndDrop(By from, By to){
        actions.dragAndDrop(driver.findElement(from), driver.findElement(to)).perform();
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
    public static void infiniteScroll() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        for (int i =0;i<4;i++){
            Thread.sleep(2000);
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
    }
    public static void horizonalSlider(int xOffSet, By locator){
        WebElement pointer = driver.findElement(locator);
        actions.clickAndHold(pointer)
                .moveByOffset(xOffSet,0)
                .perform();

    }
    public static int getElementWidth(By locator){
        return driver.findElement(locator).getSize().width;
    }
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public static void sendKeyToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public static void contextClick(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator))
                .perform();
    }
    public static void hoverAction(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator))
                .perform();
    }
    public static void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }
    public static void switchToParent(){
        driver.switchTo().parentFrame();
    }
    public static void waitForElementVisible(String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

}
