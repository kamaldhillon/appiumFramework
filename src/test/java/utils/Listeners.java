package utils;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;


import java.util.Objects;

import static utils.ExtentTestManager.getTest;

public class Listeners extends BaseTest implements ITestListener{
    static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart: " + iTestContext.getName());
        BaseTest baseTest = (BaseTest) iTestContext.getSuite().getAttribute("baseTest");
        if (baseTest != null) {
            AndroidDriver driver = baseTest.getDriver();
            if (driver == null) {
                throw new IllegalStateException("WebDriver is not initialized.");
            }
            iTestContext.setAttribute("WebDriver", driver);
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish: " + iTestContext.getName());
        // Do tear down operations for ExtentReports reporting
        ExtentTestManager.extent.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " test has succeeded.");
        // ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " test has failed.");
        Object testClass = iTestResult.getInstance();
        AndroidDriver driver = ((BaseTest) testClass).getDriver();

        // Take base64Screenshot for ExtentReports
        String base64Screenshot = "data:image/png;base64," +
                ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        // ExtentReports log and screenshot operations for failed tests
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " test is skipped.");
        // ExtentReports log operation for skipped tests
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}