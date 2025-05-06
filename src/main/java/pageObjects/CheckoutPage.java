package pageObjects;

import Resusability.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends abstractComponent {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement selectcountry;

    @FindBy(css = ".btnn.action__submit")
    WebElement submit;


    public void selectCountry(String Countryname){
        Actions a = new Actions(driver);
        a.sendKeys(country,Countryname).build().perform();
        waitforelementtoAppear(By.cssSelector(".ta-results"));
        selectcountry.click();
    }

    public Confirmationpage submitOrder(){

        submit.click();
        return new Confirmationpage(driver);
    }
}
