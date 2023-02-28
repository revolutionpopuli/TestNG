package Gun01;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
 */

public class _06_SubscribeNewsLetter extends BaseDriver {

    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("[type='radio'][value='1']");
    By no=By.cssSelector("[type='radio'][value='0']");
    By button=By.cssSelector("[value='Continue']");



    @Test (priority =1)
    void subscribeFunctionYes(){

        WebElement newsletterLink= driver.findElement(link);
        newsletterLink.click();

        WebElement subscribeYes= driver.findElement(yes);
        subscribeYes.click();

        WebElement continueButton=driver.findElement(button);
        continueButton.click();

        Tools.succesMessageValidation();


    }
    @Test(priority =2)
    void subscribeFunctionNo(){

        WebElement newsletterLink= driver.findElement(link);
        newsletterLink.click();

        WebElement subscribeNo= driver.findElement(no);
        subscribeNo.click();

        WebElement continueButton=driver.findElement(button);
        continueButton.click();

        Tools.succesMessageValidation();

    }
    @Test(priority = 3)
    void subscribeFunctionForBoth(){

        WebElement newsletterLink= driver.findElement(link);
        newsletterLink.click();


        WebElement subscribeYes= driver.findElement(yes);
        WebElement subscribeNo= driver.findElement(no);

        if(subscribeYes.isSelected()){
            subscribeNo.click();
        }else {
            subscribeYes.click();
        }

        WebElement continueButton=driver.findElement(button);
        continueButton.click();

        Tools.succesMessageValidation();

    }



}
