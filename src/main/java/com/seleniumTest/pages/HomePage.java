package com.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By loginButtonControl = By.id("myAccount");
    private By getAccountTextConrol = By.className("sf-OldMyAccount-1k66b");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonControl));
    }

    public String getAccountText() {
        waitForLoad();
        return getText(getAccountTextConrol);
    }

}