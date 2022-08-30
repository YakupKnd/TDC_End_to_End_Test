package com.trimdownclub.utilities;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }


    public static String getCurrentDateAndTime(){
        Date date = new Date();
        long longValue2 = date.getTime();

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue2), ZoneId.systemDefault());
        String formattedString = dateTime.format(DateTimeFormatter.ofPattern("ddMMyyyyHHmm"));

        return formattedString;
    }

    //parameter should be like that -> "yyyy-MM-dd HH:mm:ss.SSS"
    public static String getCurrentDateAndTime(String timePattern){
        Date date = new Date();
        long longValue2 = date.getTime();

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue2), ZoneId.systemDefault());
        String formattedString = dateTime.format(DateTimeFormatter.ofPattern(timePattern));

        return formattedString;
    }


    public static String getURL(){
        return Driver.get().getCurrentUrl();
    }

    //wait for an element to be clickable (with web element)
    public static void waitClickability(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait for an element to be clickable (with By locator)
    public static void waitClickability(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.get().findElement(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait for clickability of an element then click
    public static void clickWithWait(WebElement element, int timeOut){
        waitClickability(element,timeOut);
        element.click();
    }

    public static void waitUntilNumberOfWindows(int number){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(number));
    }

    public static void sendKeysWithWait(WebElement field, String value, int timeOut){
        waitForVisibility(field,timeOut);
        field.sendKeys(value);
    }

    public static void sendKeysWithWait(WebElement field, int value, int timeOut){
        waitForVisibility(field,timeOut);
        field.sendKeys(String.valueOf(value));
    }

    public static void sendKeysWithWait(WebElement field, double value, int timeOut){
        waitForVisibility(field,timeOut);
        field.sendKeys(String.valueOf(value));
    }

    //wait till URL contains a specific text
    public static void waitForURLContains(String urlPart, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            wait.   until(ExpectedConditions.urlContains(urlPart));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //get text as a list from a list of web elements
    public static List<String> getTextAsList(List<WebElement> elementList){
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < elementList.size(); i++) {
            newList.add(elementList.get(i).getText());
        }

        return newList;
    }

    //wait for visibility of a web element
    public static void waitForVisibility(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait for visibility of a web element
    public static void waitForVisibility(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(Driver.get().findElement(by)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //static wait - Thread.sleep()
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //static wait - Thread.sleep()
    public static void wait(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //wait until a certain text get present in a web element
    public void waitForTextContains(WebElement element,  String text){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    //wait till a new window gets opened
    public static void waitForNewWindow() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 4);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //wait till a new window gets opened
    public static void waitForAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 4);
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //switch to another window by passing index number
    public static void switchToWindow(int index) {
        try {
            waitForNewWindow();
            Set<String> windowHandles = Driver.get().getWindowHandles();
            ArrayList<String> allTabs = new ArrayList<>(windowHandles);
            Driver.get().switchTo().window(allTabs.get(index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait for a web element till has a specific text
    public static void waitForText(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 6);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //switch to iframe
    public static void switchToFrame(WebElement frame) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 4);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
//		driver.switchTo().frame(frame);
    }

    //click on a web element using JSexecutor
    public static void clickWithJSExe(WebElement element) {
        waitClickability(element, 3);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    //attempt to click on a web element a couple of times
    public static void clickManyTimes(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                waitClickability(element, 3);
                element.click();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    //attempt to click on a web element a couple of times
    public static void clickManyTimes(By by) {

        for (int i = 0; i < 3; i++) {
            try {
                WebElement element = Driver.get().findElement(by);
                waitClickability(element, 3);
                element.click();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    //open a new tab using JSexecutor
    public static void openNewTab() {
        ((JavascriptExecutor) Driver.get()).executeScript("window.open();");
    }

    //scroll into an element
    public static void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //scroll into an element
    public static void scrollToElement(By by) {
        try {
            WebElement element = Driver.get().findElement(by);
            ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static int generateRandomNumber(int size) {
        Random random = new Random();
        return random.nextInt(size);
	}
	

}
