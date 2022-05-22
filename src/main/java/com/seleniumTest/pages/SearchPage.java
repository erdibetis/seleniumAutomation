package com.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    private By searchBox = By.className("desktopOldAutosuggestTheme-input");
    private By searchButton = By.className("SearchBoxOld-buttonContainer");
    private By result = By.className("searchResultSummaryBar-bold");

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getResultText() {
        return webDriver.findElement(searchBox).getText();
    }

    public String sendText(String bookName) {
        sendKeys(searchBox, bookName,5);
        click(searchButton,5);
        waitForLoad();
        return webDriver.findElement(result).getText();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
    }
}
