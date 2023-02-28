package Gun03;

import Utility.BaseDriver;
import org.testng.annotations.*;

public class _01_Intro  {
    /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroup
       @AfterTest
     @AfterSuit
   */

    @BeforeSuite
    void suit(){System.out.println("Before Suit");}

    @BeforeTest
    void  bTest(){System.out.println("Before Test");}

    @BeforeGroups
    void Groups(){System.out.println("Before Groups");}

    @BeforeClass
    void bClass(){System.out.println("Before Class");}

    @BeforeMethod
    void bMethod(){System.out.println("Before Method");}

    @Test
    void Intro_Test1(){System.out.println("Intro_01-> Test 1");}

    @Test
    void Intro_Test2(){System.out.println("Intro_02-> Test 2");}

    @AfterMethod
    void aMethod(){System.out.println("After Method");}

    @AfterClass
    void aClass(){System.out.println("After Class");}

    @AfterGroups
    void aGroups(){System.out.println("After Groups");}

    @AfterTest
    void aTest(){System.out.println("After Test");}

    @AfterSuite
    void aSuit(){System.out.println("After Suit");}

}
