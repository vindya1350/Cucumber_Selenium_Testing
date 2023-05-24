package com.jupitertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {
    private final static String errMsgLocator = "//*[text()=' %s is required ']";
    private final static String inputFieldLocator = "mat-input-";

    @FindBy(xpath = "//button/*[text()='Contact']")
    WebElement contactTab;

    @FindBy(xpath = "//*[text()='Submit']")
    WebElement contactSubmitButton;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement successMsg;

    @FindBy(xpath = "//*[contains(text(),'Please wait while we submit your feedback')]")
    WebElement loadingBar;

    @FindBy(xpath = "//*[text()='We welcome your feedback']")
    WebElement contactPageMsg;

    @FindBy(xpath = "//*[text()='more_vert']")
    WebElement moreButton;

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectContactTab() {
        moreButton.click();
        contactTab.click();
    }

    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='Jupiter Toys']")));
        contactSubmitButton.click();
    }

    public WebElement getMandatoryFieldErrorMsg(String fieldName) {
        WebElement actualMsg = driver.findElement(By.xpath(errMsgLocator.replace("%s", fieldName)));
        return actualMsg;
    }

    public void fillForename(String name) {
        WebElement foreName = driver.findElement(By.id(inputFieldLocator + "0"));
        foreName.sendKeys(name);
    }

    public void fillEmail(String mail) {
        WebElement email = driver.findElement(By.id(inputFieldLocator + "2"));
        email.sendKeys(mail);
    }

    public void fillMsg(String msg) {
        WebElement message = driver.findElement(By.id(inputFieldLocator + "5"));
        message.sendKeys(msg);
    }

    public void fillTelephone(String telNo) {
        WebElement telephoneNo = driver.findElement(By.id(inputFieldLocator + "3"));
        telephoneNo.sendKeys(telNo);
    }

    public boolean isElementVisible(String fieldName) {
        try {
            driver.findElement(By.xpath(errMsgLocator.replace("%s", fieldName)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String successMsgIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Please wait while we submit your feedback')]")));
        return successMsg.getText();
    }

    public void selectType(String type) {
        WebElement typeDropDown = driver.findElement(By.id(inputFieldLocator + "4"));
        Select option = new Select(typeDropDown);
        option.selectByValue(type);
    }
}
