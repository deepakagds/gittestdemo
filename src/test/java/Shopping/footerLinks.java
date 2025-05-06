package Shopping;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class footerLinks {
    public static void main(String[] args) throws IOException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement> footerURL = driver.findElements(By.xpath("//li[@class=\"gf-li\"]/a"));
        for(WebElement links : footerURL){

           String link = links.getDomAttribute("href");
            String link1=  links.getText();
            System.out.println(link);
        }

}
}
