package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class F03_SearchAmazon {
    String amazon_URL = "https://www.amazon.com/";
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get(amazon_URL);
    }
    @Test
    void search() throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchInput = driver.findElement(By.cssSelector("input[id=\"twotabsearchtextbox\"]"));
        searchInput.sendKeys("Laptop");
        driver.findElement(By.cssSelector("input[id=\"nav-search-submit-button\"]")).click();

        List<WebElement> eles = driver.findElements(By.className("puis-card-container"));
        SoftAssert soft = new SoftAssert();
        for (int i = 0; i < eles.size(); i++) {
            boolean element = eles.get(i).getText().contains("Laptop");
            soft.assertTrue(element, "Element number" + i);
            System.out.println(i);
        }
        System.out.println(eles.size());
        soft.assertAll();
    }
    @AfterMethod
    void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
