package Gun05;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _06_SoftAssertVsHardAssert {
    @Test
    void hardAssert(){
        String s1="Merhaba";
        System.out.println("Hard Assert kontrol öncesi");
        Assert.assertEquals("Merhaba 123", s1, "HardAssert sonucu");
    }
    @Test
    void softAssert(){
        String strHomepage="www.facebook.com/homepage";
        String strCartpage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccount";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomepage);//true
        System.out.println("assert1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartpage);//false
        System.out.println("assert2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount);//false
        System.out.println("assert3");

        _softAssert.assertAll();//bütün assert sonuçlarını işleme koyuyor
        System.out.println("Aktiflik sonrası");



    }
}
