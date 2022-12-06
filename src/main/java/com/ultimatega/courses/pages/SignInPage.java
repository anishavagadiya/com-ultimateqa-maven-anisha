package com.ultimatega.courses.pages;

import com.ultimatega.courses.utility.Utility;
import org.openqa.selenium.By;

public class SignInPage extends Utility {
    By welcomeText = By.xpath("//h1[@class='page__heading']");
    By emailField = By.id("user[email]");
    By passwordField = By.name("user[password]");
    By signInButton = By.xpath("//body[1]/main[1]/div[1]/div[1]/article[1]/form[1]/div[5]/button[1]");
    By getErrorMessage = By.cssSelector(".form-error__list-item");

    public void enterEmailAddress(String email){

        sendTextToElement(emailField,email);
    }

    public void enterPassword(String password){

        sendTextToElement(passwordField,password);
    }

    public void clickOnSignInButton(){
        clickOnElement(signInButton);
    }
    public String getWelcomeMessage(){

        return getTextFromElement(welcomeText);
    }

    public String getErrorMessage(){

        return getTextFromElement(getErrorMessage);
    }


}
