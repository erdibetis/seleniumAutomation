package com.seleniumTest.pages;

import com.seleniumTest.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailBy = By.id("txtUserName");
    private By emailSubmitButtonBy = By.id("btnLogin");
    private By passwordBy = By.id("txtPassword");
    private By passwordSubmitButtonBy = By.id("btnEmailSelect");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage login(User user) {
        sendKeys(emailBy, user.getEmail(),5);
        click(emailSubmitButtonBy,5);
        sendKeys(passwordBy, user.getPassword(),5);
        click(passwordSubmitButtonBy, 5);

        HomePage homePage = new HomePage(webDriver);
        homePage.waitForLoad();

        return homePage;
    }
}
