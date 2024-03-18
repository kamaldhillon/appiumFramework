import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{

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
}
