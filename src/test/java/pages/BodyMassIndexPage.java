package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

public class BodyMassIndexPage {

    By metricTab = By.xpath("//a[text()='Metric Units']");
    By clearButton = By.xpath("//input[@value='Clear']");
    By ageTextbox = By.xpath("//input[@id='cage']");
    By maleRadioButton = By.id("csex1");
    By femaleRadioButton = By.id("csex2");
    By heightTextbox = By.xpath("//input[@name='cheightmeter']");
    By weightTextbox = By.xpath("//input[@name='ckg']");
    By caculateButton = By.xpath("//input[@value='Calculate']");
    By getResultBMI = By.className("bigtext");
//    public BodyMassIndexPage(WebDriver driver){
//        this.driver = driver;
//    }
    public void openUrl(){
        Browser.visit("https://www.calculator.net/bmi-calculator.html");
    }
    public void selectMetricTab(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(metricTab)).click();
       // Browser.click(metricTab);
    }
    public void clearMetricTab(){
        Browser.click(clearButton);
    }
    public void fillForm(String age,String gender, String height, String weight){
        Browser.sendKeys(ageTextbox,age);
        if (gender.equalsIgnoreCase("male")){
            Browser.check(maleRadioButton);
        }else {
            Browser.check(femaleRadioButton);
        }

        Browser.sendKeys(heightTextbox,height);
        Browser.sendKeys(weightTextbox,weight);


    }
    public void selectCalculateButton(){
        Browser.click(caculateButton);

    }
    public String getResult(){
        return Browser.getText(getResultBMI);
    }

}
