package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait waitLong;
    protected WebDriverWait waitShot;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitLong = new WebDriverWait(driver,Duration.ofSeconds(15));
        waitShot = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void load(String endpoint){
        driver.get("https://askomdch.com");
    }

    public void waitOverlayToBeDisappered(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OverLay Found: "+overlays.size());
        if (overlays.size()>0) {
            waitLong.until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("Overlay Handled.");
        }else{
            System.out.println("No OverLay Found.");
        }
    }
}
