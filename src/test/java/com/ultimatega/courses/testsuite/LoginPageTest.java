package com.ultimatega.courses.testsuite;

import com.ultimatega.courses.pages.Homepage;
import com.ultimatega.courses.pages.SignInPage;
import com.ultimatega.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    Homepage homepage = new Homepage();
    SignInPage loginPage = new SignInPage();


   @Test
   public void userShouldNavigateToLoginPageSuccessfully(){
       homepage.clickOnSignInButton();
       String expectedSignInText = "Welcome Back!";
       Assert.assertEquals(loginPage.getWelcomeMessage(),expectedSignInText,"Welcome Back! is not displayed");
   }
   @Test
    public void verifyTheErrorMessage() throws InterruptedException {
       homepage.clickOnSignInButton();
       loginPage.enterEmailAddress("test11@yahoo.com");
       loginPage.enterPassword("test123");
       Thread.sleep(5000);
       loginPage.clickOnSignInButton();
       String expectedErrormessage = "Invalid email or password.";
       Assert.assertEquals(loginPage.getErrorMessage(),expectedErrormessage,"Invalid email or password message not displayed ");

   }

}


