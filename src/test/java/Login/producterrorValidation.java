package Login;

import Testcomponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageObjects.Cartpage;
import pageObjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class producterrorValidation extends BaseTest {

    @Test
    public void loginerrorMessage() throws IOException, InterruptedException {

        String ProductName = "ZARA COAT 3";
        ProductCatalogue productcatalogue = landingpage.Loginapplication("deepakag@yopmail.com", "deepa");
        System.out.println("Login details are incorrect");
    }

    @Test
    public void getproductValiationMesage() throws IOException, InterruptedException {

        String ProductName = "ZARA COAT 3";
        ProductCatalogue productcatalogue = landingpage.Loginapplication("usertest4@yopmail.com", "Admin@123");
        List<WebElement> prod = productcatalogue.getProductList();
        productcatalogue.addProducttoCart(ProductName);
        Cartpage cartpage = productcatalogue.gotoCartpage();
        Boolean match = cartpage.verifyProductDisplay("Jara Coat 33");
        Assert.assertTrue(match);


        }



}

