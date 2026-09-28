package SeleniumFirstScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F06_Alerts {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void handleAlert(){
        WebElement clickJSBtnAlert = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        clickJSBtnAlert.click();

        driver.switchTo().alert().accept();

        WebElement msgLoc = driver.findElement(By.id("result"));
        boolean actualRes = msgLoc.getText().contains("You successfully clicked an alert");
        Assert.assertTrue(actualRes);
    }
    @Test
    void handleConfirmAlert(){
        WebElement clickJSBtnAlert = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        clickJSBtnAlert.click();

        String s = driver.switchTo().alert().getText();
        if (s.equals("I am a JS Confirm")){
            driver.switchTo().alert().accept();
        }else {
            driver.switchTo().alert().dismiss();
        }
        boolean actual = driver.findElement(By.id("result")).getText().contains("You clicked: Ok");
        Assert.assertTrue(actual);
    }
    @Test
    void handlePromptAlert(){
        WebElement clickJSBtnAlert = driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        clickJSBtnAlert.click();

        String s = "Seif Ahmed";
        driver.switchTo().alert().sendKeys(s);
        driver.switchTo().alert().accept();

        WebElement resLoc = driver.findElement(By.id("result"));
        boolean actualRes = resLoc.getText().contains(s);
        Assert.assertTrue(actualRes);
    }
}
