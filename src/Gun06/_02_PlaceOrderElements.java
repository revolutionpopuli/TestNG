package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_PlaceOrderElements {

    public _02_PlaceOrderElements() {
        // Bu sayfadaki bütün elementlerin driverlar bağlantısı gerekiyor
        // bunun için aşağıdaki consructor eklendi ve içini PageFactory ile
        // driver üzerinden bu (this) sayfadaki bütün elemanlar ilşkilendirildi.
        // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
        // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
        // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
        // gelmiş oluyor. Bu yapıya Page Object Model (POM) adı veriliyor.

        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(css = "[class='input-group-btn']>button")
    public WebElement searchBtn;

    @FindBy(xpath = "(//span[text()='Add to Cart'])")
    public WebElement addToCart;

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement shopping;

    @FindBy(xpath= "//span[text()='Checkout']")
    public WebElement checkout;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;


    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(name = "agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(css = "[id='content']>h1")
    public WebElement verify;


}
