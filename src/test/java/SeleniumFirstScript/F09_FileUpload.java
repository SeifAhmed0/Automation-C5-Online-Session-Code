package SeleniumFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class F09_FileUpload {
    WebDriver driver;
    String FileUpload_URL = "https://the-internet.herokuapp.com/upload";

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();    // Open Browser
        driver.get(FileUpload_URL);      // Open URL
        driver.manage().window().maximize();
    }
    @Test
    void FileUpload() {

        SoftAssert s = new SoftAssert();
        String fileName = "FileUploadDummy.txt";

        WebElement browseBtnLoc = driver.findElement(By.id("file-upload"));
        browseBtnLoc.sendKeys("E:\\" + fileName);

        WebElement subBtnLoc = driver.findElement(By.id("file-submit"));
        subBtnLoc.click();

        boolean actual1 = driver.findElement(By.tagName("h3")).isDisplayed();
        s.assertTrue(actual1);

        boolean actual2 = driver.findElement(By.id("uploaded-files")).getText().contains(fileName);
        s.assertTrue(actual2);

        s.assertAll();

    }
}
