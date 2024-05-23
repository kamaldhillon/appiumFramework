package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtil {

    static ExtentReports extent;

    public static ExtentReports getReportObject(){

        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("test");
        reporter.config().setDocumentTitle("test results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}

