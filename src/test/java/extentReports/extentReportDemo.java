package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class extentReportDemo {
    ExtentReports extent;

    @BeforeTest
    public  void  config(){
    //Extent report ExtentSpark reporter
        String reportpath = System.getProperty("user.dir")+ "//Reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
        reporter.config().setReportName("Web Automation report");
        reporter.config().setDocumentTitle("Testing report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Deepak Agarwal");


    }
        @Test
        public void initialDemo(){
        ExtentTest test = extent.createTest("Login demo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.getTitle();
        //test.fail("test failed");
        extent.flush();
    }
}