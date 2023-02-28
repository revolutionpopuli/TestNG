package Gun07;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamanlardan random bir elemanın Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

 */
public class _01_WishList extends BaseDriverParameter {

    @Test
    @Parameters("searchText")
    void addWishList(String arananKelime) {

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys(arananKelime);

        WebElement searchBtn=driver.findElement(By.cssSelector("[class='input-group-btn']>button"));
        searchBtn.click();

        List<WebElement> searchResults=driver.findElements(By.cssSelector("div[class='caption']>h4"));
        int randomSecim= Tools.RandomNumberGenerator(searchResults.size());
        String wishItemText=searchResults.get(randomSecim).getText();//ürünün adını aldım

        List<WebElement>wishBtnList=driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishBtnList.get(randomSecim).click();//aynı ürün wish liste eklendi

        WebElement btnWishList= driver.findElement(By.id("wishlist-total"));
        btnWishList.click();

        List<WebElement>wishTableNames=driver.findElements(By.cssSelector("td[class='text-left']>a"));
        Tools.listContainsString(wishTableNames, wishItemText);



    }

}
