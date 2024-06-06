package test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class ScrollTest extends BaseTest {

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
    }

    @Test
    public void swipeNewTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        Dimension size = driver.manage().window().getSize();

        //center point of screen
        int startX= size.getWidth()/2;
        int startY=size.getHeight()/2;

        int endX=startX;
        int endY=(int)(size.getHeight()*0.25);

        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence s = new Sequence(finger1,1);
        s.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(20)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(s));
    }

}
