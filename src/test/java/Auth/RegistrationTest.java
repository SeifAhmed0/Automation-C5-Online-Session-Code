package Auth;

import org.testng.annotations.*;

public class RegistrationTest {

    // BEFORE TESTS
    @BeforeClass
    void setUpClass(){
        System.out.println("BeforeClass RegistrationTest");
    }

    @BeforeMethod
    void setUpMethod(){
        System.out.println("BeforeMethod RegistrationTest");
    }

    // AFTER TESTS
    @AfterClass
    void closeClass(){
        System.out.println("AfterClass RegistrationTest");
    }

    @AfterMethod
    void closeMethod(){
        System.out.println("AfterMethod RegistrationTest");
    }

    // TESTS
    @Test
    void TC_C(){
        System.out.println("TC_C RegistrationTest");
    }

    @Test
    void TC_D(){
        System.out.println("TC_D RegistrationTest");
    }

}
