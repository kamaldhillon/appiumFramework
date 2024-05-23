package test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.Test;
import pageobjects.android.FirstPage;

import static utils.ExtentTestManager.startTest;


public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        startTest("param");
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
