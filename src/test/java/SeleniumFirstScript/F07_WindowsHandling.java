package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class F07_WindowsHandling {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    void handleTabs(){
        String title = driver.getTitle();
        System.out.println(title);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String currentTabId = driver.getWindowHandle();
        System.out.println(currentTabId);
    }
    @Test
    void handleMultibleTabs(){
        WebElement clickBtnLoc = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickBtnLoc.click();
        clickBtnLoc.click();
        clickBtnLoc.click();
        System.out.println(driver.getCurrentUrl());

        List<String> TabsIds = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(TabsIds.get(1));
        System.out.println(driver.getCurrentUrl());

        boolean actual = driver.findElement(By.tagName("h3")).isDisplayed();
        Assert.assertTrue(actual);
        driver.close(); // to close the tab not the whole driver

        driver.switchTo().window(TabsIds.get(0));
        System.out.println(driver.getCurrentUrl());
    }
}
