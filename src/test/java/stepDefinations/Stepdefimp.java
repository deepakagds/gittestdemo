package stepDefinations;

import Testcomponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;
import java.util.List;

public class Stepdefimp extends BaseTest {

    public landingPage landingPage;
    public ProductCatalogue productcatalogue;
    public Cartpage cartpage;
    public Confirmationpage confirmationpage;


    @Given("I landead on the Ecommerce Page")
    public void I_landead_on_the_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();


    }

    @Given("^I logged in with username (.+) and passwqord (.+)$")
    public void I_logged_in_with_usernameand_passwqord(String userName, String Password) {
        productcatalogue = landingpage.Loginapplication(userName, Password);

    }

    @When("^I added product (.+) to the cart$")
    public void I_added_product_to_the_cart(String productName) throws InterruptedException {
        List<WebElement> prod = productcatalogue.getProductList();
        productcatalogue.addProducttoCart(productName);

    }

    @When("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName) {
        cartpage = productcatalogue.gotoCartpage();
        Boolean match = cartpage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutpage = cartpage.goToCheckout();
        checkoutpage.selectCountry("India");
        confirmationpage = checkoutpage.submitOrder();

    }


    @Then("{string} order message is displaying")
    public void orderMessageIsDisplaying(String string) {
        String message = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("{string} message is displayed")
    public void Incorrect_email_password_Message_isD_displayed(String string) {
        Assert.assertEquals(string,"Incorrect email or passwod");

    }
}