package configuration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public abstract class AbstractPageObjectClass{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public AbstractPageObjectClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public abstract void waitForPageToLoad();

    protected boolean isElementPresent(WebElement element ) {
        try {
            if(element != null && element.isDisplayed()){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected boolean isElementPresent(By by ) {
        try {
            if(driver.findElements(by).size()>0){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected <V>V optionalWaitUntil(int seconds, com.google.common.base.Function<? super WebDriver, V> condition) {
        wait = new WebDriverWait(driver, seconds);
        try {
            WebDriverWait optionalWait =  new WebDriverWait(driver, seconds);
            return optionalWait.until(condition);
        } catch (Exception e) {
            return null;
        }
    }

    protected  void confirmDialog(){driver.switchTo().alert().accept();}

    protected void hoverOverElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }

    protected AbstractPageObjectClass refreshPage(){
        driver.navigate().refresh();
        return this;
    }

    protected void switchBetweenWindows(String window){
        for (String handler : driver.getWindowHandles()){
            if(!handler.equals(window))
                driver.switchTo().window(handler);
        }
    }

    protected void scrollToTop(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0,0)");
    }

}
