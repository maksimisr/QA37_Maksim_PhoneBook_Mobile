package tests;

import config.ApiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends ApiumConfig {

    @Test
    public void loginSuccess(){
      //  boolean result = new SplashScreen(driver)
              //  .checkCurrentVersion("Version 1.0.0")

        boolean result= new AuthentificationScreen(driver)
                .fillEmail("maks-skam@mail.ru")

                .fillPassword("Maksim1996$")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");

        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel(){
      //  boolean result =   new SplashScreen(driver)
              //  .checkCurrentVersion("Version 1.0.0")
        boolean result= new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("maks-skam@mail.ru").password("Maksim1996$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }


    @Test
    public void loginWrongEmail(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("Maksim@mail,ru").password("Maksim1996$").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("maks-skam@mail.ru").password("maksim1996").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
    @AfterMethod
    public void postCondition(){
       new ContactListScreen(driver).logout();
    }
}
