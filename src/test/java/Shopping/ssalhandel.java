package Shopping;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ssalhandel {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
}