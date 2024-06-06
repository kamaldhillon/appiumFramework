package test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.PerformsTouchID;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.time.Duration;
import java.util.Collections;

public class DragTest extends BaseTest {

    @Test
    public void dragAndDropUsingJSExecutor() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)source).getId(),
                "endX",655,
                "endY", 655
        ));

        Thread.sleep(3000);
        String dropText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(dropText,"Dropped!");

    }

    @Test
    public void dragAndDropUsingTouchAction() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));


        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target)).release().perform();

        Thread.sleep(3000);
        String dropText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(dropText,"Dropped!");

    }

    @Test
    public void dragAndDropUsingW3Action() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));


        Point sourceLocation = source.getLocation();
        Dimension sourceSize = source.getSize();
        Point targetLocation = target.getLocation();
        Dimension targetSize = target.getSize();

        int startX = sourceLocation.x+sourceSize.width/2;
        int startY=sourceLocation.y+sourceSize.height/2;
        int endX=targetLocation.x+targetSize.width/2;
        int endY=targetLocation.y+targetSize.height/2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1,1);
        sequence.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                                .addAction(new Pause(finger1,Duration.ofMillis(2000)))
                                        .addAction(finger1.createPointerMove(Duration.ofMillis(1345),PointerInput.Origin.viewport(),endX,endY))
                                                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(3000);
        String dropText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(dropText,"Dropped!");

    }
}
