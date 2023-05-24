package com.jupitertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPaymentDetailsPage extends BasePage{

    private final static String cardTypeLocator = "//*[text()='%s']";

    public CheckoutPaymentDetailsPage(WebDriver driver) {
        super(driver);
    }
    
    public void fillCardNumber(String cardNo) {
        getFieldElement("Enter your Credit Card No").sendKeys(cardNo);
    }

    public void selectCardType(String type){
        WebElement typeDropdown = driver.findElement(By.xpath("//*[text()='Select Type']"));
        typeDropdown.click();
        WebElement cardType =  driver.findElement(By.xpath(cardTypeLocator.replace("%s", type)));
        cardType.click();;
    }

    public void fillCardName(String name) {
        getFieldElement("Name on card").sendKeys(name);
    }

    public void fillExpiryDate(String date) {
        getFieldElement("dd/MM").sendKeys(date);
    }

    public void fillCvvNumber(String cvv) {
        getFieldElement("123").sendKeys(cvv);
    }

    private WebElement getFieldElement(String fieldName) {
        return driver.findElement(By.xpath("//*[@data-placeholder=\""+fieldName+"\"]"));
    }

    public void navigateToConfirmOrderSection(){
        WebElement nextButton = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']//*[text()='Next']"));
        nextButton.click();
    }

}
