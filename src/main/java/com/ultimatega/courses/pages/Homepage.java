package com.ultimatega.courses.pages;

import com.ultimatega.courses.utility.Utility;
import org.openqa.selenium.By;

public class Homepage extends Utility {
    By SignInButton = By.linkText("Sign In");

    public void clickOnSignInButton(){
        clickOnElement(SignInButton);
    }

}
