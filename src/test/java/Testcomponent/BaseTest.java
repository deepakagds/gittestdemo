package Testcomponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.landingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {

    public WebDriver driver;
    public landingPage landingpage;

    public WebDriver InitalizeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Resources//Globaldata.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            //Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            //edge
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @BeforeMethod
    public landingPage launchApplication() throws IOException {
        driver = InitalizeDriver();
        landingpage = new landingPage(driver);
        landingpage.goTo();
        return landingpage;

    }

    @AfterMethod
    public void teardown() throws IOException {
        driver.close();
    }

    public List<HashMap<String, String>> getJsaonDatamap(String filePath) throws IOException {

        String JasonData = FileUtils.readFileToString(new File(filePath));
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(JasonData, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot screnshot = (TakesScreenshot)driver;
        File source = screnshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") +"//Reports//"+ testcaseName +".png");
        FileUtils.copyFile(source, file );
        return System.getProperty("user.dir")+ "//Reports//"+ testcaseName +".png";


    }



}

