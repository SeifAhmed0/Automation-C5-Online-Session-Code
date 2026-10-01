package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class F10_Frames {
    WebDriver driver;
    String Frame_URL = "https://the-internet.herokuapp.com/nested_frames";

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();    // Open Browser
        driver.get(Frame_URL);      // Open URL
        driver.manage().window().maximize();
    }
    @Test
    void Frame() {

//        WebElement topFrame = driver.findElement(By.name("frame-top"));
//        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-top");
        WebElement leftFrame = driver.findElement(By.name("frame-left"));
        driver.switchTo().frame(leftFrame);
        String leftText = driver.findElement(By.tagName("body")).getText();
        System.out.println(leftText);

        driver.switchTo().parentFrame();

        WebElement middleTopFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleTopFrame);
        String middleText = driver.findElement(By.id("content")).getText();
        System.out.println(middleText);

        driver.switchTo().defaultContent();

        WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(bottomFrame);
        String bottomText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bottomText);

    }
}
