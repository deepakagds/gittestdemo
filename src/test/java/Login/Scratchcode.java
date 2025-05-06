package Login;

import Testcomponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Scratchcode extends BaseTest {
    String ProductName = "ZARA COAT 3";

    @Test(dataProvider = "getdata", groups = {"purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
    {

        ProductCatalogue productcatalogue = landingpage.Loginapplication(input.get("email"), input.get("password"));
        List<WebElement> prod = productcatalogue.getProductList();
        productcatalogue.addProducttoCart(input.get("ProductName"));
        Cartpage cartpage = productcatalogue.gotoCartpage();
        Boolean match = cartpage.verifyProductDisplay(input.get("ProductName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutpage = cartpage.goToCheckout();
        checkoutpage.selectCountry("India");
        Confirmationpage confirmationpage = checkoutpage.submitOrder();
        String message = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
        System.out.println("Test completed");
        System.out.println("happy path");
    }


    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderhistoryProduct()  {

        ProductCatalogue productcatalogue = landingpage.Loginapplication("deepakag@yopmail.com", "Admin@123");
        Ordeerpage ordeerpage = productcatalogue.myOrder();
        System.out.println(ordeerpage.verifyOrderDisplay(ProductName));
        Assert.assertTrue(ordeerpage.verifyOrderDisplay(ProductName));

    }

    @DataProvider
    public Object[][] getdata() throws IOException {
//        HashMap<String,String> map = new HashMap<String,String>();
//        map.put("email","deepakag@yopmail.com");
//        map.put("password","Admin@123");
//        map.put("ProductName","ZARA COAT 3");
//
//        HashMap<String,String> map1 = new HashMap<String,String>();
//        map1.put("email","usertest4@yopmail.com");
//        map1.put("password","Admin@123");
//        map1.put("ProductName","ADIDAS ORIGINAL");

       List<HashMap<String,String>> data=  getJsaonDatamap(System.getProperty("user.dir") + "//src//test//java//data//purchaseOrder.json");

        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
