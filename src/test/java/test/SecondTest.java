package test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

public class SecondTest extends BaseTest {

    @Test
    public void secondTest() throws InterruptedException {

         driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        driver.executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",2000));
        Thread.sleep(2000);
        Assert.assertEquals("Sample menu",driver.findElement(By.id("android:id/title")).getText());
    }

    @Test
    public void longPressTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        Point location = element.getLocation();
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence s= new Sequence(finger1,1);
        s.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),location))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                                .addAction(new Pause(finger1,Duration.ofMillis(3000)))
                                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(s));


        Assert.assertEquals("Sample menu",driver.findElement(By.id("android:id/title")).getText());
    }
}
