package pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {
    AndroidDriver driver;
    public SamplePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"App\"]")

    private  WebElement clickOnApp;

    public  void setClickOnApp() {
        clickOnApp.click();
    }
}
