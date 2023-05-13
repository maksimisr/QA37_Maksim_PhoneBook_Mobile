package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextVeiw;

    @FindBy(id = "//*[@content-desc='More options']")
    AndroidElement menuOptions;

    @FindBy(id = "//*[@text='Logout']")
    AndroidElement logoutButton;


    public boolean isActivityTitleDisplayed(String text){

       // return activityTextVeiw.getText().contains("Contact list");
        return  isShouldHave(activityTextVeiw,text,10);
    }

    public AuthentificationScreen logout(){
menuOptions.click();
logoutButton.click();
return new AuthentificationScreen(driver);
    }
}
