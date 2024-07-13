package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablePage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableTest extends TestBase {
    WebTablePage webTablePage = new WebTablePage();
    @Test
    void verifyLargeDuePerson(){
        webTablePage.open();


        Assert.assertEquals(webTablePage.getMaxDuePerson() , List.of("Doe Jason"));
        //Assert.assertEquals(maxDuePerson.getFullName(),"Doe Jason");

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
