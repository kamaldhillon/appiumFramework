package pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstPage{

    AndroidDriver driver;
    public FirstPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility="Preference")
    private WebElement preferenceField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    private WebElement preferenceDependencyField;

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement checkBox;

    @AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
    private WebElement wifiSettingsField;

    @AndroidFindBy(id="android:id/edit")
    private WebElement wifiInputField;

    @AndroidFindBy(id="android:id/button1")
    private WebElement btn;

    public void clickOnPreference(){
        preferenceField.click();
    }
    public void clickOnPreferenceDependenices(){
        preferenceDependencyField.click();
    }

    public  void clickOnCheckBox(){
        checkBox.click();
    }

    public void clickOnWifiSettings(){
        wifiSettingsField.click();
    }

    public void setWifiName(String name){
        wifiInputField.sendKeys(name);
    }

    public void btnClick(){
        btn.click();
    }

}
