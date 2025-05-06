package Resusability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Cartpage;
import pageObjects.Ordeerpage;


import java.time.Duration;

public class abstractComponent {

 WebDriver driver;

    public abstractComponent(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement Cartheader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement myOrder;



    public void waitforelementtoAppear(By findBy){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}

public void waitforelementtoDisapper(WebElement ele ) throws InterruptedException {
        Thread.sleep(2000);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    wait.until(ExpectedConditions.invisibilityOf(ele));

}

public Cartpage gotoCartpage(){
    Cartheader.click();
    Cartpage cartpage = new Cartpage(driver);
    return cartpage;

}

    public Ordeerpage myOrder() {
        myOrder.click();
        Ordeerpage orderpage = new Ordeerpage(driver);
        return orderpage ;

    }
}
