import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.android.FirstPage;

public class FirstTest extends BaseTest{

    @Test
    public void firstTest() {

        FirstPage page = new FirstPage(driver);
        page.clickOnPreference();
        page.clickOnPreferenceDependenices();
        page.clickOnCheckBox();
//        DeviceRotation rotate=new DeviceRotation(0,0,90);
//        driver.rotate(rotate);
        page.clickOnWifiSettings();
        //     driver.setClipboardText("kamal");
        page.setWifiName("kamal");

//        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
