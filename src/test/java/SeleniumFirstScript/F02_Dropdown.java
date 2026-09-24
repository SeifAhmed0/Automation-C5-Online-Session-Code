package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class F02_Dropdown {
    WebDriver driver;
    String AppURL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get(AppURL);
    }
    @Test(priority = 0)
    void selectOptionByText(){
        WebElement dropdownField = driver.findElement(By.xpath("//a[@href=\"/dropdown\"]"));
        dropdownField.click();

        WebElement dropdownLoc = driver.findElement(By.id("dropdown"));
        Select sel = new Select(dropdownLoc);
        sel.selectByVisibleText("Option 1");

        WebElement optionOneLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        boolean actualResult = optionOneLoc.isSelected();
        Assert.assertTrue(actualResult);

    }
    @Test(priority = 1)
    void selectOptionByIndex(){
        WebElement dropdownField = driver.findElement(By.xpath("//a[@href=\"/dropdown\"]"));
        dropdownField.click();

        WebElement dropdownLoc = driver.findElement(By.id("dropdown"));
        Select sel = new Select(dropdownLoc);
        sel.selectByIndex(1);

        WebElement optionOneLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        boolean actualResult = optionOneLoc.isSelected();
        Assert.assertTrue(actualResult);
    }
    @Test(priority = 2)
    void selectOptionByValue(){
        WebElement dropdownField = driver.findElement(By.xpath("//a[@href=\"/dropdown\"]"));
        dropdownField.click();

        WebElement dropdownLoc = driver.findElement(By.id("dropdown"));
        Select sel = new Select(dropdownLoc);
        sel.selectByValue("1");

        WebElement optionOneLoc = driver.findElement(By.cssSelector("option[value=\"1\"]"));
        boolean actualResult = optionOneLoc.isSelected();
        Assert.assertTrue(actualResult);
    }
    @Test
    void handleDropdown(){
        WebElement dropdownField = driver.findElement(By.xpath("//a[@href=\"/dropdown\"]"));
        dropdownField.click();

        List<WebElement> eles = driver.findElements(By.tagName("option"));
        eles.get(1).click();

        WebElement optionLoc = driver.findElement(By.cssSelector(""));
    }
    @AfterMethod
    void close() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
