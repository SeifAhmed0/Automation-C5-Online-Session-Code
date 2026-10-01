package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class F08_DataProvider {
    WebDriver driver;
    String HEROKUAPP_URL = "https://the-internet.herokuapp.com/login";

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();    // Open Browser
        driver.get(HEROKUAPP_URL);      // Open URL
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "DP")
    void Login(String username, String password){
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(username);

        WebElement passWordField = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        passWordField.sendKeys(password);

        WebElement loginBtnField = driver.findElement(By.className("fa-sign-in"));
        loginBtnField.click();

        boolean actual = driver.findElement(By.cssSelector("i[class=\"icon-2x icon-signout\"]")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "DP")
    String [][] provideData() {
        String[][] data = {
                {"tomsmith", "SuperSecretPassword!"},
                {"Seif", "456789"},
                {"Ahmed", "Wqe123"}
        };
        return data;
    }
}
