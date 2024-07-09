package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenImgTest {
    @Test
    void verifyBrokenImage(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
//        WebElement img1 = driver.findElement(By.xpath("//div[@class='example']/img[3]"));
//        String naturalHeight = img1.getDomProperty("naturalHeight");
//        String naturalWidth = img1.getDomProperty("naturalWidth");
//        System.out.println(naturalHeight + naturalWidth);
        driver.findElements(By.xpath("//div[@class='example']/img")).forEach(img1 -> {
            String naturalHeight = img1.getDomProperty("naturalHeight");
            String naturalWidth = img1.getDomProperty("naturalWidth");
            System.out.println(naturalHeight + naturalWidth);
        });

    }
}
