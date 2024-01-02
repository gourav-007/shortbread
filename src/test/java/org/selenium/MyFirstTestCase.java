package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

        driver.get("https://askomdch.com/");

        BillingAddress billingAddress = JacksonUtils.deSerialize("myBillingAddress.json", BillingAddress.class);
         Product product = new Product(1215);

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        System.out.println(product.getName());
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn(product.getName());
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickOnViewCartBtn();
        Assert.assertEquals(cartPage.getProductName(),product.getName());
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage
                .setBillingData(billingAddress)
                .clickOnPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        String product = "Blue Shoes";

        BillingAddress billingAddress = BillingAddress
                .builder()
                .firstName("demo")
                .lastName("user")
                .addressLineOne("San Francisco")
                .city("San Francisco")
                .postalCode("94188")
                .email("demouser94188@outlook.com")
                .build();

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn(product);
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickOnViewCartBtn();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickOnLoginLink();
        Thread.sleep(5000);
        checkoutPage
                .login("demouser94189","demouser94189")
                .enterFirstName("demo")
                .enterLastName("user")
                .enterBillingAddress1("San Francisco")
                .enterBillingCity("San Francisco")
                .enterBillingPostCode("94188")
                .enterBillingEmail("demouser94188@outlook.com")
                .clickOnPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }
}
