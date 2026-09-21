package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F01_Login {

    String HEROKUAPP_URL = "https://the-internet.herokuapp.com/login";
    String userName = "tomsmith";
    String validPassWord = "SuperSecretPassword!";
    String invalidPassWord = "123456";
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();    // Open Browser
        driver.get(HEROKUAPP_URL);      // Open URL
    }
    @Test(priority = 0)
    void validLogin(){
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(userName);

        WebElement passWordField = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        passWordField.sendKeys(validPassWord);

        WebElement loginBtnField = driver.findElement(By.className("fa-sign-in"));
        loginBtnField.click();

        WebElement msgField = driver.findElement(By.id("flash"));
        boolean actualMsgField = msgField.getText().contains("You logged into a secure area!");
        Assert.assertEquals(actualMsgField, true, "The Text is not Exist!");

        WebElement logoutBtn = driver.findElement(By.className("icon-signout"));
        boolean actual = logoutBtn.isDisplayed();
        Assert.assertTrue(actual, "Logout Button is not Displayed!");
    }
    @Test(priority = 1)
    void invalidLogin(){
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(userName);

        WebElement passWordField = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        passWordField.sendKeys(invalidPassWord);

        WebElement loginBtnField = driver.findElement(By.className("fa-sign-in"));
        loginBtnField.click();

        WebElement errorMsgField = driver.findElement(By.id("flash"));
        boolean actualMsgField = errorMsgField.getText().contains("Your password is invalid!");
        Assert.assertEquals(actualMsgField, true);

    }
    @AfterMethod
    void close(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
