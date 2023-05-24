package com.jupitertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutContactDetailsPage extends BasePage {

    private final static String stateLocator = "//mat-option[@value='%s']";

    public CheckoutContactDetailsPage(WebDriver driver){
        super(driver);
    }
    
    public void fillFirstName(String fname) {
        fillField("First name").sendKeys(fname);
    }

    public void fillLastName(String lName){
        fillField( "Last name").sendKeys(lName);
    }

    public void fillEmail(String mail){
        fillField("Email").sendKeys(mail);
    }

    public void fillPhoneNo(String telNo){
        fillField("Phone Number").sendKeys(telNo);
    }

    public void fillContactAddress(String address){
        fillField("Address Line 1").sendKeys(address);
    }

    public void fillContactSuburb(String suburbName){
        fillField("Suburb").sendKeys(suburbName);
    }

    public void selectState(String stateName){
        WebElement stateDropDown = driver.findElement(By.xpath("//*[text()='State']"));
        stateDropDown.click();
        WebElement state =  driver.findElement(By.xpath(stateLocator.replace("%s", stateName)));
        state.click();
    }

    public void fillContactPostCode(String code){
        fillField("Postcode").sendKeys(code);
    }
  
    public void navigateToDeliveryDetailsSection(){
        WebElement nextButton = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-0']//*[text()='Next']"));
        nextButton.click();
    }

    private WebElement fillField(String fieldName) {
        return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-0']//*[@data-placeholder=\""+fieldName+"\"]"));
    }
}
