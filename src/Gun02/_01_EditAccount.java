package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */
public class _01_EditAccount extends BaseDriver {
    By editAccount = By.linkText("Edit Account");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By submitButton = By.cssSelector("input[type='submit']");


    @Test
    void EditAccount() {
        editAccountTest("ali", "yılmaz");
        Tools.bekle(2);
        editAccountTest("Test", "NG");


    }


    void editAccountTest(String ad, String soyad) {

        WebElement edit = driver.findElement(editAccount);
        edit.click();

        WebElement txtFirstname = driver.findElement(firstName);
        txtFirstname.clear();
        txtFirstname.sendKeys(ad);

        WebElement txtLastname = driver.findElement(lastName);
        txtLastname.clear();
        txtLastname.sendKeys(soyad);

        WebElement btnSubmit = driver.findElement(submitButton);
        btnSubmit.click();

        Tools.succesMessageValidation();

    }


}
