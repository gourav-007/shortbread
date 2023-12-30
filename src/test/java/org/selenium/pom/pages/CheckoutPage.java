package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckoutPage extends BasePage {

    private final By firstNameTxtBox = By.id("billing_first_name");
    private final By lastNameTxtBox = By.id("billing_last_name");
    private final By billingAddressTxtBox = By.id("billing_address_1");
    private final By billingCityTxtBox = By.id("billing_city");
    private final By billingPostcodeTxtBox = By.id("billing_postcode");
    private final By billingEmailTxtBox =  By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.xpath("//p[contains(normalize-space() ,'Thank you. Your order has been received.')]");
    private final By loginLink = By.xpath("//a[@class='show login' or contains(text(),'login')]");

    private final By userEmailFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String fname){
        driver.findElement(firstNameTxtBox).clear();
        driver.findElement(firstNameTxtBox).sendKeys(fname);
        return this;
    }

    public CheckoutPage enterLastName(String lname){
        driver.findElement(lastNameTxtBox).clear();
        driver.findElement(lastNameTxtBox).sendKeys(lname);
        return this;
    }

    public CheckoutPage enterBillingAddress1(String address){
        driver.findElement(billingAddressTxtBox).clear();
        driver.findElement(billingAddressTxtBox).sendKeys(address);
        return this;
    }

    public CheckoutPage enterBillingCity(String city){
        driver.findElement(billingCityTxtBox).clear();
        driver.findElement(billingCityTxtBox).sendKeys(city);
        return this;
    }

    public CheckoutPage enterBillingPostCode(String code){
        driver.findElement(billingPostcodeTxtBox).clear();
        driver.findElement(billingPostcodeTxtBox).sendKeys(code);
        return this;
    }

    public CheckoutPage enterBillingEmail(String email){
        driver.findElement(billingEmailTxtBox).clear();
        driver.findElement(billingEmailTxtBox).sendKeys(email);
        return this;
    }

    public void clickOnPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
    }

    public String getNotice(){
        return driver.findElement(successNotice).getText();
    }

    public void clickOnLoginLink(){
        driver.findElement(loginLink).click();
    }

    public CheckoutPage enterUsername(String name){
        driver.findElement(userEmailFld).sendKeys(name);
        return this;
    }

    public CheckoutPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckoutPage clickOnLogin(){
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckoutPage login(String username, String password){
        enterUsername(username)
                .enterPassword(password)
                .clickOnLogin();
        return this;
    }

}