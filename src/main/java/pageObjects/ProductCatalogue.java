package pageObjects;

import Resusability.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCatalogue extends abstractComponent {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By ProductsBY = By.cssSelector(".mb-3");
    By Addtocart =  By.cssSelector(".card-body button:last-of-type");
    By tostmessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList() {
        waitforelementtoAppear(ProductsBY);
        return products;
    }

    public WebElement getProductbyNames(String ProductName){
        WebElement prod = getProductList().stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
        return prod;

    }

    public void addProducttoCart(String ProductName) throws InterruptedException {
        WebElement prod = getProductbyNames(ProductName);
        prod.findElement(Addtocart).click();
        waitforelementtoAppear(tostmessage);
        waitforelementtoDisapper(spinner);

    }
}

