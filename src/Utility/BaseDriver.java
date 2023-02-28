package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass (groups = "SmokeTest")
    public void baslangicIslemleri(){
        System.out.println("Başlangıç işlemleri");
        //ilk adımda çalışan kısım

        Logger logger= Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeService yi sessiz modda çalıştır


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();  // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor

        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisayarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün webelementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre.

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        loginTest();
    }
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
    @AfterClass(enabled = true, groups = "SmokeTest")
    public void bitisIslemleri(){
        System.out.println("Bitiş işlemleri");
        Tools.bekle(3);
        driver.quit();
    }
}
