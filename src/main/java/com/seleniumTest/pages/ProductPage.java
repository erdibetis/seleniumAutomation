package com.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ProductPage extends BasePage {

    private By product = By.xpath("//*[@id=\"i0\"]/div/a/div[2]/div[1]/div[2]/div[1]");
    private By addBasket = By.className("moria-ProductCard-bnMPLu gZQXnw sumnjc5ssrf sc-fzpans jgULOA sc-fzplWN hRBsWH");
    private By addBasketXpath = By.xpath("//*[@id=\"i0\"]/div/a/div[3]/div[4]/button");
    private By checkedAddBasketText = By.className("hb-toast-text");


    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String clickProduct() {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(webDriver.findElement(product)).perform();
        click(addBasketXpath,5);
        getText(checkedAddBasketText);
        return webDriver.findElement(checkedAddBasketText).getText();
    }

}
