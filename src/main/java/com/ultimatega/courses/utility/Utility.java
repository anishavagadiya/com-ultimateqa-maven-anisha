package com.ultimatega.courses.utility;

import com.ultimatega.courses.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        //Find the Email Field element and send the email
        WebElement emailField = driver.findElement(by);
        //type email to email field
        // emailField.sendKeys("test123@gmail.com");
        emailField.sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
//********** Alert Methods *************

    //Switch to Alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //Switch to AcceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //Switch to DismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //Switch to String getText from Alert
    public String getTextFromAlert() {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }

    //SendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //****************************Select Class Method ************************************************
    //Select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //Select option Value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //Select option by Index
    public void selectByIndexFromDropDown(By by, int indexNum) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNum);

    }
    //This is Select the option by contains text


    //**********************Window Handle*************************************

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //**************************Action Class *********************************
    // mouseHoverToElement(),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }

    // mouseHoverToElementAndClick(By by)
    public void mouseHoveToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        actions.moveToElement(mouseClick).click().build().perform();

    }

//********************************Waits Methods******************************************************

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }


}
