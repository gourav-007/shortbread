package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By storeMenuLink = By.xpath("//li[contains(@id,'menu-item-122')]//a[@class='menu-link' and contains(text(),'Store')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public StorePage navigateToStoreUsingMenu(){
        waitLong.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StorePage(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

}
