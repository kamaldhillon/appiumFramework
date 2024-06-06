package pageobjects.android;

import com.aventstack.extentreports.util.Assert;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class DragPage {

    AndroidDriver driver;
    public DragPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility="Views")
    private WebElement views;

    @AndroidFindBy(accessibility = "Drag and Drop")
    private WebElement dragAndDrop;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement source;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement dropTxt;

    String dropText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();


    public void clickOnPViews(){
        views.click();
    }
    public void clickOnDragAndDrop(){
        dragAndDrop.click();
    }

    public  void drag(){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",ImmutableMap.of(
                "elementId", ((RemoteWebElement)source).getId(),
                "endX",655,
                "endY", 655
        ));

    }

    public String verifyDrop(){

      return dropTxt.getText();
    }



}
