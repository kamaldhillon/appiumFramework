package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

    ExtentReports extentReports= ExtentUtil.getReportObject();

    public void onTestStart(ITestResult result){
        ExtentTest test = extentReports.createTest("initial");
    }
}