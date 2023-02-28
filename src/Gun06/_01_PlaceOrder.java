package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
public class _01_PlaceOrder extends BaseDriver {
    @Test
    void proceedToCheckout() {

    WebElement searchText = driver.findElement(By.name("search"));
    searchText.sendKeys("ipod");

    WebElement searchBtn=driver.findElement(By.cssSelector("[class='input-group-btn']>button"));
    searchBtn.click();

    WebElement ipod= driver.findElement(By.xpath("(//span[text()='Add to Cart'])"));
    ipod.click();

    WebElement shopping= driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
    shopping.click();

    WebElement checkout=driver.findElement(By.xpath("//span[text()='Checkout']"));
    checkout.click();

    WebElement continue1=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
    continue1.click();

    WebElement continue2=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
    continue2.click();

    WebElement continue3=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
    continue3.click();

    WebElement agree=driver.findElement(By.name("agree"));
    agree.click();

    WebElement continue4=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
    continue4.click();

    WebElement confirm=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
    confirm.click();

    wait.until(ExpectedConditions.urlContains("success"));

    WebElement h1=driver.findElement(By.cssSelector("[id='content']>h1"));
    Assert.assertEquals(h1.getText(), "Your order has been placed!", "Onay texti bulunamadı");





}


}
