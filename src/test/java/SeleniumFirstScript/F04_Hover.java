package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

public class F04_Hover {
    String hover_URL = "https://the-internet.herokuapp.com/hovers";
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get(hover_URL);
        driver.manage().window().maximize();
    }
    @Test
    void hover(){
        Actions act = new Actions(driver);
        WebElement imgLoc = driver.findElement(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]"));
        act.moveToElement(imgLoc).perform();
        driver.findElement(By.xpath("//a[@href=\"/users/1\"]")).click();

        SoftAssert soft = new SoftAssert();
        boolean actual = driver.findElement(By.tagName("h1")).isDisplayed();
        soft.assertTrue(actual);

        boolean actual_URL = driver.getCurrentUrl().contains("users/1");
        soft.assertTrue(actual_URL);

        soft.assertAll();
    }
    @AfterMethod
    void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
