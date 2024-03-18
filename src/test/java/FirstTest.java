import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void firstTest() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("kamal");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
