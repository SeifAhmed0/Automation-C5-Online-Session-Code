package SeleniumFirstScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F05_Waits {

    // Unconditional Wait => Thread.sleep(3000)

    // Conditional Waits => Implicit : DOM Page, Explicit : Per Element, Fluent

    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @Test
    void testA(){
//        driver.findElement().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
    }
    @Test
    void testFluentWait(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element was not found after 10 seconds with polling period 2 seconds");

        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    }
}
