package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By productNameTxt = By.xpath("//tbody//td[@data-title='Product']/child::a[contains(normalize-space(),'Blue Shoes')]");
    private final By clickOnCheckOutBtn = By.xpath("//a[contains(normalize-space() ,'Proceed to checkout')]");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(productNameTxt)).getText();
    }

    public CheckoutPage checkout(){
        waitLong.until(ExpectedConditions.elementToBeClickable(clickOnCheckOutBtn)).click();
        return new CheckoutPage(driver);
    }

}