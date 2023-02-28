package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
    /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */

    @BeforeClass
    void  beforeClass(){
        System.out.println("her class dan ÖNCE çalışacak"); //driver ve diğer test öncesi bütün işlemler
    }
    @BeforeMethod
    void beforeMetod(){
        System.out.println("Her metod dan ÖNCE çalışacak");
    }
    @AfterMethod
    void afterMetod(){
        System.out.println("Her metod dan SONRA çalışacak");
    }
    @AfterClass
    void  afterClass(){
        System.out.println("her class dan SONRA çalışacak"); //driverkapat vs.
    }
    @Test
    void test1(){
        System.out.println("test 1 çalıştı");
    }
    @Test
    void test2(){
        System.out.println("test 2 çalıştı");
    }

}
