package Auth;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A {

    @BeforeMethod
    void setUp(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    void cleanUp(){
        System.out.println("AfterMethod");
    }

    @Test(priority = 0, invocationCount = 3, enabled = false, dependsOnMethods = {"TC_A"})  // using invocationCount with flaky tests
    void TC_B(){    // using dependsOnMethods = {"TC_A"} means if TC_A Pass, TC_B will run BUT if TC_A Fail, TC_B will not run
        // regardless of the priority TC_A will run first due to dependsOnMethods = {"TC_A"}
        System.out.println("TC_B LoginTest");
    }

    @Test(priority = 1)
    void TC_A(){
        System.out.println("TC_A LoginTest");
    }

}
