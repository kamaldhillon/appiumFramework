import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest{

    @Test
    public void scrollTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        Thread.sleep(2000);
    }


    @Test
    public void swipe(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        //AppPackage and App activity
        // command adb shell dumpsys window  | grep -E "mCurrentFocus"
//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//                "intent","io.appium.android.apis/io.appium.android.apis.ApiDemos"));

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        Assert.assertTrue(Boolean.parseBoolean(element.getAttribute("focusable")));

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction","left",
                "percent", 0.75
        ));

        Assert.assertEquals(element.getAttribute("focusable"),"false");

    }

}
