package Shopping;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class addProducts {

    public static void main(String[] args) {

        String[] itemsNeed = {"Brocolli", "Cucumber", "Beetroot"};

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        addProducts addp = new addProducts();
        addp.addItems(driver, itemsNeed);

    }

    public static void addItems(WebDriver driver, String[] itemsNeed) {
        int j = 0;
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < productNames.size(); i++) {


            String[] products = productNames.get(i).getText().split("-");
            String formattedName = products[0].trim();
            List itemNeededList = Arrays.asList(itemsNeed);


            if (itemNeededList.contains(formattedName)) {

                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeed.length) {
                    break;
                }
            }


        }
    }
}