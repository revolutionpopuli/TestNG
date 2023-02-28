package Gun01;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Assertions extends BaseDriver {
    // Yeşil tik : test de hata yok
    // Sarı çarpi : test de hata var
    // Beyaz  : test çalıştırılmadı.skip

    @Test
    void equalOrnek() {

        String s1 = "Merhaba";
        String s2 = "Merhaba";
                       //actual, expected, mesaj(opsiyonel)
        Assert.assertEquals(s1, s2, "kaKarşılaştırma sonucu");

    }

    @Test
    void notequalOrnek() {

        String s1 = "Merhaba";
        String s2 = "Merhaba1";
                         //actual, expected, mesaj(opsiyonel)
        Assert.assertNotEquals(s1, s2, "Karşılaştırma sonucu");
    }

    @Test
    void trueOrnek() {
        int s1 = 55;
        int s2 = 66;

        Assert.assertTrue(s1 == s2, "Karşılaştırma sonucu");
    }

    @Test
    void nullOrnek() {

        String s1 = "Merhaba";

        Assert.assertNull(s1, "Karşılaştırma sonucu");
    }
    @Test
    void directFail(){
        int a=55;
        if(a==55)
            Assert.fail();
    }
}