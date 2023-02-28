package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */
public class _00_AddressFunctionality extends BaseDriver {

@Test

    void addAddress(){

    WebElement addressBook=driver.findElement(By.linkText("Address Book"));
    addressBook.click();

    WebElement newAddress=driver.findElement(By.linkText("New Address"));
    newAddress.click();

    WebElement firstName=driver.findElement(By.id("input-firstname"));
    firstName.sendKeys("Ahmet");

    WebElement lastname=driver.findElement(By.id("input-lastname"));
    lastname.sendKeys("Demir");

    WebElement company=driver.findElement(By.id("input-company"));
    company.sendKeys("Techno Study");

    WebElement address1=driver.findElement(By.id("input-address-1"));
    address1.sendKeys("21a London Road");

    WebElement address2=driver.findElement(By.id("input-address-2"));
    address2.sendKeys("RG2 5BJ");

    WebElement city=driver.findElement(By.id("input-city"));
    city.sendKeys("Reading");

    WebElement postCode=driver.findElement(By.id("input-postcode"));
    postCode.sendKeys("12345");

    WebElement country=driver.findElement(By.id("input-country"));
    Select countrySelect= new Select(country);
    countrySelect.selectByIndex(10);

    WebElement option=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
    wait.until(ExpectedConditions.stalenessOf(option));//stale element durumu düzelene kadar bekle

    WebElement State=driver.findElement(By.id("input-zone"));
    Select StateSelect= new Select(State);

    //System.out.println("StateSelect = " + StateSelect.getFirstSelectedOption().getSize());
    //for(WebElement e:StateSelect.getOptions())
     //   System.out.println("e.getText() = " + e.getText());//inceleme için geçiş anının fotoğrafı. Sadece bir kısmını yazdırdı.

    StateSelect.selectByIndex(6);//selectByVisibleText ve selectValue implicitly wait ile çalıştığı için hata vermez.
    // selectByIndex imlplicitly wait ile çalışmıyor. Hata verir.
    //selectByVisibleText, selectValue ile sorunsuz çalışır ve beklemeye ihtiyacı kalmaz.

    WebElement defadres=driver.findElement(By.cssSelector("label [name='default'][value='1']"));
    defadres.click();

    WebElement ctn=driver.findElement(By.cssSelector("input[type='submit']"));
    ctn.click();

    Tools.succesMessageValidation();

}
@Test(dependsOnMethods = {"addAddress"})
    void editAddress(){

    WebElement addressBook=driver.findElement(By.linkText("Address Book"));
    addressBook.click();

    List<WebElement> editAll=driver.findElements(By.linkText("Edit"));
    WebElement sonEdit= editAll.get(editAll.size()-1); // son edit
    sonEdit.click();

    WebElement firstName=driver.findElement(By.id("input-firstname"));
    firstName.clear();
    firstName.sendKeys("Mehmet");

    WebElement lastname=driver.findElement(By.id("input-lastname"));
    lastname.clear();
    lastname.sendKeys("Yılmaz");

    WebElement ctn=driver.findElement(By.cssSelector("input[type='submit']"));
    ctn.click();

    Tools.succesMessageValidation();

}
@Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){
    WebElement addressBook=driver.findElement(By.linkText("Address Book"));
    addressBook.click();

    List<WebElement> deleteAll=driver.findElements(By.linkText("Delete"));
    WebElement silinebilirAdres= deleteAll.get(deleteAll.size()-2); // son edit
    silinebilirAdres.click();

    Tools.succesMessageValidation();

}

}
