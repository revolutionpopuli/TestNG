package Gun04;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimesini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */
public class _04_SearchFunctionalityPD extends BaseDriverParameter {

    @Test
    @Parameters("input")
    void searchFunction(String searchTxt){

        WebElement searchInput= driver.findElement(By.name("search"));
        searchInput.sendKeys(searchTxt);

        WebElement searchButton= driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions= driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for(WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(searchTxt));




    }
}
