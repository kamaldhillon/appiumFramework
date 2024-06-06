package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.android.SamplePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class SampleTest {
   AppiumServiceBuilder service;
   protected AndroidDriver driver;



   @Test
    public void baseConfig(){


       service= new AppiumServiceBuilder().withAppiumJS(new File("/Users/kamaljitkaur/node_modules/appium/build/lib/main.js"))
               .withIPAddress("127.0.0.1").usingPort(4723);

       UiAutomator2Options options = new UiAutomator2Options();
       options.setDeviceName("Pixel 4a API 34");
       options.setPlatformName("android");
       options.setApp("//Users//kamaljitkaur//Downloads//resources//ApiDemos-debug.apk");
       options.setAutomationName("UIAutomator2");

       AppiumDriverLocalService localService=service.build();
       localService.start();

       driver = new AndroidDriver(options);
       SamplePage page = new SamplePage(driver);
        page.setClickOnApp();

        Set set = driver.getContextHandles();
        set.forEach(e->System.out.println(e));
         driver.close();
       localService.stop();
   }

}

