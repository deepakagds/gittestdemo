package pageObjects;

import Resusability.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Ordeerpage extends abstractComponent {

    WebDriver driver;

    public Ordeerpage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> Productnames;

    public Boolean verifyOrderDisplay(String ProductName) {
        Boolean match = Productnames.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
        return match;
    }
}