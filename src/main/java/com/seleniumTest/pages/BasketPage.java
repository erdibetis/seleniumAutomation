package com.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {

    private By basketButton = By.id("shoppingCart");
    private By pageControl = By.className("basket_headerTop_15H0U");
    private By completeShopping = By.id("continue_step_btn");
    private By addressPageContol = By.xpath("//*[@id=\"shipping_container\"]/h2");
    private By addressPageContinueButton = By.id("continue_step_btn");
    private By paymentMethods = By.className("sardesPaymentPage-index-payment_methods_container");


    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void getBasketPageDetail() {
        click(basketButton,10);
    }

    public String basketPageControl() {
        waitForLoad();
        return webDriver.findElement(pageControl).getText();
    }

    public String completeShoppingButton() {
        click(completeShopping,5);
        getText(addressPageContol);
        return webDriver.findElement(addressPageContol).getText();
    }

    public String addressContinueButton() {
        click(addressPageContinueButton,5);
        getText(paymentMethods);
        return webDriver.findElement(paymentMethods).getText();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageControl));
    }


}
