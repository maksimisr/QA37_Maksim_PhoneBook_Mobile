package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthentificationScreen extends BaseScreen{
    public AuthentificationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
//xpath="//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView
@FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
AndroidElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    AndroidElement passwordEditText;
    // @FindBy(xpath = "//*[text()='LOGIN']")
    @FindBy(xpath = "//*[@text='LOGIN']")
    AndroidElement loginButton;

    public AuthentificationScreen fillEmail(String email){

        should(emailEditText,10);
        type(emailEditText,email);

        return  this;
    }



    public AuthentificationScreen fillPassword(String password){

        type(passwordEditText,password);

        return this;
    }

    public ContactListScreen submitLogin(){
        loginButton.click();

        return new ContactListScreen(driver);
    }

    public AuthentificationScreen fillLoginRegistrationForm(Auth auth){
        should(emailEditText,10);
        type(emailEditText, auth.getEmail());
        type(passwordEditText,auth.getPassword());
        return this;
    }


    public AuthentificationScreen submitLoginNegative(){
        loginButton.click();
        return this;
    }

    public AuthentificationScreen isErrorMessageContainsText(String text){
        Alert alert = new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;
    }
}
