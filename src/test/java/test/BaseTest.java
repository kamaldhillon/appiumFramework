package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AppiumDriverLocalService service;
    protected AndroidDriver driver;

    @BeforeClass
    public  void baseConfig() throws IOException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//kamaljitkaur//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("KamalPhone");
        options.setApp("/Users/kamaljitkaur/Downloads/resources/ApiDemos-debug.apk");
        options.setLogcatFormat("threadtime");
//        options.setCapability("browserName","Chrome");
//        options.setCapability("chromedriverExecutable","//Users//KamaljitKaur//Downloads//chromedriver.exe");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Start capturing logcat logs
        File logFile = new File("crash_logs.txt");
        Process logcatProcess = new ProcessBuilder("adb", "logcat", "-v", "threadtime")
                .redirectOutput(logFile).start();


//        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
    public AndroidDriver getDriver() {
        return driver;
    }
}

