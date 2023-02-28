package Gun01;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriver {

    @Test
    void loginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("login test");
        WebElement inputEmail= driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("testng0@gmail.com");

        WebElement inputPassword= driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("testNG0");

        WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(), "My Account", "login başarısız");

        Tools.bekle(5);

    }

}
