package com.jupitertoys.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutConfirmOrderPage extends BasePage {

    @FindBy(xpath = "//*[text()='Payment Failed']")
    WebElement failMsg ;

    public CheckoutConfirmOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void submitOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Submit Order']")));
        driver.findElement(By.xpath("//*[text()='Submit Order']")).click();
    }
    
    public String unsuccessMsgIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[text()='Submit Order']")));
        return failMsg.getText();
    }
    
}
