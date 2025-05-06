package Testcomponent;


import Resusability.proejctnewreport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = proejctnewreport.getreportObject();
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

    @Override
     public void onTestStart(ITestResult result) {
         //System.out.println("New Test Started " +result.getName());
         test = extent.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
     }

     @Override
     public void onTestSuccess(ITestResult result) {
         //System.out.println("onTestSuccess Method " +result.getName());
         extenttest.get().log(Status.PASS, "Test has been passed");
     }

     @Override
     public void onTestFailure(ITestResult result) {
         //System.out.println("onTestFailure Method" +result.getName());
         extenttest.get().fail(result.getThrowable());

         try {
             driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                     .get(result.getInstance());
         }
         catch (Exception e1) {
             e1.printStackTrace();

         }

         String FilePath = null;
         try {
             FilePath = getScreenshot(result.getMethod().getMethodName(),driver);
         } catch (IOException e) {
             e.printStackTrace();
         }
         extenttest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());

     }

    @Override
     public void onTestSkipped(ITestResult result) {
         System.out.println("onTestSkipped Method" +result.getName());
     }
    @Override
     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
         System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
     }

     @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }

 }




