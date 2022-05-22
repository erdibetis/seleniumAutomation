package com.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentManagementPage extends BasePage {

    private By instantRemittance = By.className("sardesPaymentPage-Accordion-header_context");
    private By akbankSelect = By.xpath("//*[@id=\"payment-money-transfer\"]/div/div[1]/div[1]/div[2]/div/div[2]/p[1]");
    private By continueButton = By.id("continue_step_btn");
    private By summaryPageBankControl = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[1]/section[3]/div/div/div/div[2]/ul/li/div[1]/span[2]");


    public PaymentManagementPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectInstantRemittance() {
        click(instantRemittance,5);
    }

    public String clickBank() {
        click(akbankSelect,5);
        waitForLoad(akbankSelect);
        return webDriver.findElement(akbankSelect).getText();
    }

    public String continueButton(){
        click(continueButton,5);
        waitForLoad(summaryPageBankControl);
        return webDriver.findElement(summaryPageBankControl).getText();
    }

    public void waitForLoad(By path) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
}
