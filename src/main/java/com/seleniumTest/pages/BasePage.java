package com.seleniumTest.pages;


import com.seleniumTest.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebDriverHelper {

    //login sayfası açılacak
    private By loginButton = By.id("myAccount");
    private By comboboxLoginButton = By.id("login");

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage getLoginPage() {
        click(loginButton, 10);
        click(comboboxLoginButton,5);
        return new LoginPage(webDriver);
    }


    public void enterHomePageLoginButton(String keyword) {
        webDriver.findElement(loginButton).sendKeys(keyword);
    }


}
