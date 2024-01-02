package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
 private final String product = "Blue Shoes";
    private final By enterTextInSearchFld = By.xpath("//form[@role='search']//child::input[contains(@placeholder,'Search products…')]");
    private final By clickOnSearchBtn = By.xpath("//form[@role='search']//child::button[contains(text(),'Search')]");
    private final By clickOnViewCartBtn = By.xpath("//a[contains(normalize-space() ,'View cart') and @title='View cart']");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchFld(String product){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(enterTextInSearchFld)).sendKeys(product);
        return this;
    }

    public StorePage search(String product){
        enterTextInSearchFld(product)
                .clickOnSearchBtn();
        return this;
    }
    private void clickOnSearchBtn() {
        driver.findElement(clickOnSearchBtn).click();
    }

    private By getTitleElement(){
        return By.xpath("//h1[contains(normalize-space() ,'Blue')]");
    }
    public String getTitle(){
        By titleElement = getTitleElement();
        return driver.findElement(titleElement).getText();
    }
    private By getClickAddToCartBtnElement(String product){
        return By.xpath("//a[contains(normalize-space() ,'Add to cart') and @aria-label='Add “" + product + "” to your cart']");
    }
    public StorePage clickAddToCartBtn(String product){
        By clickAddToCartBtnElement = getClickAddToCartBtnElement(product);
        waitLong.until(ExpectedConditions.elementToBeClickable(clickAddToCartBtnElement)).click();
        return this;
    }
    public CartPage clickOnViewCartBtn(){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(clickOnViewCartBtn)).click();
        return new CartPage(driver);
    }

}