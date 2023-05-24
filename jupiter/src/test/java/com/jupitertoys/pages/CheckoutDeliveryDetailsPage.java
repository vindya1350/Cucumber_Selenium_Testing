package com.jupitertoys.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutDeliveryDetailsPage extends BasePage{

    public CheckoutDeliveryDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void usesameContactDetailsAsDeliveryDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='cdk-step-content-0-0']//*[text()='Next']")));
        driver.findElement(By.xpath("//*[text()=' Yes ']")).click();
    }

    public Map<String,String> getDeliveryDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Same as Contact Address: ']")));
        WebElement deliveryState = driver.findElement(By.xpath("//*[@id='mat-select-value-3']//*[contains(@class,'mat-select-min-line')]"));
        Map<String,String> filledDeliveryDetails = new HashMap<>();
        filledDeliveryDetails.put("Name", getElement("Name").getAttribute("value"));
        filledDeliveryDetails.put("AddressLine1", getElement("Address Line 1").getAttribute("value"));
        filledDeliveryDetails.put("Suburb", getElement("Suburb").getAttribute("value"));
        filledDeliveryDetails.put("State", deliveryState.getText());
        filledDeliveryDetails.put("PostCode", getElement("Postcode").getAttribute("value"));
        return filledDeliveryDetails;
    }

    public void navigateToPaymentDetailsSection(){
        WebElement nextButton = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']//*[text()='Next']"));
        nextButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cdk-step-content-0-2']//*[text()='Next']")));
    }

    private WebElement getElement(String fieldname) {
        WebElement element = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']//*[@data-placeholder=\""+fieldname+"\"]"));
        return element;
    }

    
}
