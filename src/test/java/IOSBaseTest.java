import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSBaseTest {
    AppiumDriverLocalService service;
    IOSDriver driver;

    @BeforeClass
    public  void baseConfig() throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//kamaljitkaur//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 pro");
        options.setApp("/Users/kamaljitkaur/Downloads/UIKitCatalog.app");
        options.setPlatformVersion("16.2");
        options.setPlatformName("IOS");
        options.setUdid("C5F39856-0AEA-4DF3-A95B-74A7D2ABCA8A");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}

