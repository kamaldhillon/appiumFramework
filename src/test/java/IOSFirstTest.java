import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOSFirstTest extends IOSBaseTest{

    @Test
    public void firstTest() {

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

    }
}
