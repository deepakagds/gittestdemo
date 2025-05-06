package Shopping;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowHandle {

    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
       Iterator<String> it = windows.iterator();
       String parentID= it.next();
       String childID= it.next();
       driver.switchTo().window(childID);
       System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
       String emailID =driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
       driver.switchTo().window(parentID);
       driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailID);
}}

