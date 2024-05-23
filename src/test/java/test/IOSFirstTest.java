package test;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import test.IOSBaseTest;

public class IOSFirstTest extends IOSBaseTest {

    @Test
    public void firstTest() {

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

    }
}
