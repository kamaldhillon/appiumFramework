package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static org.testng.ITestNGMethod.*;
import static utils.Listeners.getTestMethodName;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentUtil.getReportObject();
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
    public static synchronized ExtentTest startTest(String desc) {

        ExtentTest test = extent.createTest( desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}

