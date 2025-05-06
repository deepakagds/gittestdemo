package pageObjects;

import Resusability.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cartpage extends abstractComponent {

    WebDriver driver;

    public Cartpage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    List<WebElement> CartProducts;

    @FindBy(css = ".totalRow button")
    WebElement CheckoutEle;



 public Boolean verifyProductDisplay(String ProductName ){
     Boolean match = CartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
     return match;


}

    public CheckoutPage goToCheckout() {
        CheckoutEle.click();
       return new CheckoutPage(driver);

    }




}
