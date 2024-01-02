package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
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

        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        CartPage cartPage = storePage.clickAddToCartBtn(product.getName())
                .clickOnViewCartBtn();

        Assert.assertEquals(cartPage.getProductName(),product.getName());
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage
                .setBillingData(billingAddress)
                .selectDirectBankTransfer()
                .clickOnPlaceOrder();

        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        Product product = new Product(1215);
        User user = new User(1);
        BillingAddress billingAddress = JacksonUtils.deSerialize("myBillingAddress.json", BillingAddress.class);

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        CartPage cartPage = storePage.clickAddToCartBtn(product.getName())
                .clickOnViewCartBtn();

        Assert.assertEquals(cartPage.getProductName(),product.getName());
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickOnLoginLink();

        checkoutPage
                .login(user)
                .setBillingData(billingAddress)
                .selectDirectBankTransfer()
                .clickOnPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }
}
