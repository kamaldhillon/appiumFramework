package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import test.BaseTest;

public class ExtentUtil  {

    public static final ExtentReports extent = new ExtentReports();

    public synchronized static ExtentReports getReportObject(){

//        String path=System.getProperty("user.dir")+"\\extent-reports\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-report/report.html");
        reporter.config().setReportName("test");
        reporter.config().setDocumentTitle("test results");

        extent.attachReporter(reporter);
        return extent;
    }
}

