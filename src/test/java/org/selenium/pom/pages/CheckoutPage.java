package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

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
    private final By overlay = By.xpath("//div[@class='blockUI blockOverlay']");
    private final By countryDrpDwn = By.id("billing_country");
    private final By countryState = By.id("billing_state");
    private final By selectDirectbankTransfer =  By.id("payment_method_bacs");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String fname){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(firstNameTxtBox));
        element.clear();
        element.sendKeys(fname);
        return this;
    }

    public CheckoutPage enterLastName(String lname){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(lastNameTxtBox));
        element.clear();
        element.sendKeys(lname);
        return this;
    }

    public CheckoutPage selectCountry(String country){
        Select select = new Select(driver.findElement(countryDrpDwn));
        select.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage enterBillingAddress1(String address){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(billingAddressTxtBox));
        element.clear();
        element.sendKeys(address);
        return this;
    }

    public CheckoutPage enterBillingCity(String city){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(billingCityTxtBox));
        element.clear();
        element.sendKeys(city);
        return this;
    }

    public CheckoutPage selectState(String state){
        Select select = new Select(driver.findElement(countryState));
        select.selectByVisibleText(state);
        return this;
    }


    public CheckoutPage enterBillingPostCode(String code){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(billingPostcodeTxtBox));
        element.clear();
        element.sendKeys(code);
        return this;
    }

    public CheckoutPage enterBillingEmail(String email){
        WebElement element = waitLong.until(ExpectedConditions.visibilityOfElementLocated(billingEmailTxtBox));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement radio = driver.findElement(selectDirectbankTransfer);
        if (!radio.isSelected()){
            radio.click();
        }
        return this;
    }


    public CheckoutPage setBillingData(BillingAddress billingAddress){
        return  enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterBillingAddress1(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterBillingPostCode(billingAddress.getPostalCode()).
                enterBillingEmail(billingAddress.getEmail());
    }


    public void clickOnPlaceOrder(){
        waitOverlayToBeDisappered(overlay);
        driver.findElement(placeOrderBtn).click();
    }

    public String getNotice(){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public void clickOnLoginLink(){
        waitLong.until(ExpectedConditions.presenceOfElementLocated(loginLink)).click();
    }

    public CheckoutPage enterUsername(String name){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(userEmailFld)).sendKeys(name);
        return this;
    }

    public CheckoutPage enterPassword(String password){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
        return this;
    }

    public void clickOnLogin(){
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }

    public CheckoutPage login(User user){
        enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickOnLogin();
        return this;
    }



}