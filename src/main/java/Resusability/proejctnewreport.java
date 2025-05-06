package Resusability;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class proejctnewreport {


    public static ExtentReports getreportObject(){
    //Extent report ExtentSpark reporter
        String reportpath = System.getProperty("user.dir")+ "//Reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
        reporter.config().setReportName("Web Automation report");
        reporter.config().setDocumentTitle("Testing report");

        ExtentReports extent  = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Deepak Agarwal");
        return extent;


    }

}