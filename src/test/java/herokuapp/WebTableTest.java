package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableTest {
    @Test
    void verifyLargeDuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> dues = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(element -> element.getText().replace("$",""))
                .map(Double::valueOf)
                .collect(Collectors.toList());


        Double maxDue = dues.stream().max(Comparator.naturalOrder()).get();
        int maxDueIndex = dues.indexOf(maxDue);

        String lastName = driver.findElement(By.xpath(String.format("//*[@id='table1']/tbody/tr[%d]/td[1]",maxDueIndex+1))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//*[@id='table1']/tbody/tr[%d]/td[2]",maxDueIndex+1))).getText();

        Assert.assertEquals("Doe Jason",String.format("%s %s",lastName,firstName));
        driver.quit();

    }

    @Test
    void verifyMinDuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> dues = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(element -> element.getText().replace("$",""))
                .map(Double::valueOf)
                .collect(Collectors.toList());


        Double minDue = dues.stream().min(Comparator.naturalOrder()).get();
        int minDueIndex = dues.indexOf(minDue);

        String lastName = driver.findElement(By.xpath(String.format("//*[@id='table1']/tbody/tr[%d]/td[1]",minDueIndex+1))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//*[@id='table1']/tbody/tr[%d]/td[2]",minDueIndex+1))).getText();

        System.out.printf("%s %s",lastName, firstName);
        //Assert.assertEquals("Doe Jason",String.format("%s %s",lastName,firstName));
        driver.quit();


    }
}
