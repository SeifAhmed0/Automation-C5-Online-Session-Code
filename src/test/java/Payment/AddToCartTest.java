package Payment;

import org.testng.annotations.*;

public class AddToCartTest {

    // BEFORE TESTS
    @BeforeTest
    void setUpTest(){
        System.out.println("BeforeTest AddToCartTest");
    }

    @BeforeClass
    void setUpClass(){
        System.out.println("BeforeClass AddToCartTest");
    }

    @BeforeMethod
    void setUpMethod(){
        System.out.println("BeforeMethod AddToCartTest");
    }

    // AFTER TESTS
    @AfterTest
    void closeTest(){
        System.out.println("AfterTest AddToCartTest");
    }

    @AfterClass
    void closeClass(){
        System.out.println("AfterClass AddToCartTest");
    }

    @AfterMethod
    void closeMethod(){
        System.out.println("AfterMethod AddToCartTest");
    }

    // TESTS
    @Test
    void TC_A(){
        System.out.println("TC_A AddToCartTest");
    }

    @Test
    void TC_B(){
        System.out.println("TC_B AddToCartTest");
    }
    
}
