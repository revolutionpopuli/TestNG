package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _02_ContactUs extends BaseDriver {

    @Test
    @Parameters("mesaj")//xml deki parametre adıyla aynı olmak zorunda
    void contactUs(String gelenMesaj) {//metod için gerekli tanımlama, aynı olmak zorunda değil

        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement enquiry=driver.findElement(By.id("input-enquiry"));
        enquiry.sendKeys(gelenMesaj);

        WebElement submit= driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));








    }
}
