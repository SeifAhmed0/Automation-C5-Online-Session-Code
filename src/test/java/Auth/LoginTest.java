package Auth;

import org.testng.annotations.*;

public class LoginTest {

    // BEFORE TESTS
    @BeforeSuite
    void setUpSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void setUpTest(){
        System.out.println("BeforeTest LoginTest");
    }

    @BeforeClass
    void setUpClass(){
        System.out.println("BeforeClass LoginTest");
    }

    @BeforeMethod
    void setUpMethod(){
        System.out.println("BeforeMethod LoginTest");
    }

    // AFTER TESTS
    @AfterSuite
    void closeSuite(){
        System.out.println("AfterSuite");
    }

    @AfterTest
    void closeTest(){
        System.out.println("AfterTest LoginTest");
        System.out.println("========================================");
    }

    @AfterClass
    void closeClass(){
        System.out.println("AfterClass LoginTest");
    }

    @AfterMethod
    void closeMethod(){
        System.out.println("AfterMethod LoginTest");
    }

    // TESTS
    @Test
    void TC_A(){
        System.out.println("TC_A LoginTest");
    }

    @Test
    void TC_B(){
        System.out.println("TC_B LoginTest");
    }

}
