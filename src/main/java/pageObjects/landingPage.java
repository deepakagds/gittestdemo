package pageObjects;

import Resusability.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends abstractComponent {

    WebDriver driver;

    public landingPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement UserEmail;

    @FindBy(id = "userPassword")
    WebElement UserPassword;

    @FindBy(id = "login")
    WebElement Login;


 public ProductCatalogue Loginapplication(String email, String password){

     UserEmail.sendKeys(email);
     UserPassword.sendKeys(password);
     Login.click();
     ProductCatalogue productcatalogue = new ProductCatalogue(driver);
     return productcatalogue;

}

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }



}
