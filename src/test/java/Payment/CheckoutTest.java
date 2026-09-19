package Payment;

import org.testng.annotations.*;

public class CheckoutTest {

    // BEFORE TESTS
    @BeforeClass
    void setUpClass(){
        System.out.println("BeforeClass CheckoutTest");
    }

    @BeforeMethod
    void setUpMethod(){
        System.out.println("BeforeMethod CheckoutTest");
    }

    // AFTER TESTS
    @AfterClass
    void closeClass(){
        System.out.println("AfterClass CheckoutTest");
    }

    @AfterMethod
    void closeMethod(){
        System.out.println("AfterMethod CheckoutTest");
    }

    // TESTS
    @Test
    void TC_C(){
        System.out.println("TC_C CheckoutTest");
    }

    @Test
    void TC_D(){
        System.out.println("TC_D CheckoutTest");
    }

}
