package com.jupitertoys.pages;

import java.text.DecimalFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FindBy(xpath = "//*[text()='more_vert']")
    WebElement moreButton;

    @FindBy(xpath = "//tfoot//*[contains(text(),'Total')]")
    WebElement totalCost;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductIsAddedToCart(String productName) {
        WebElement productDetails = getToyDetailsRow(productName);
        if (productDetails != null) {
            return true;
        } else {
            return false;
        }
    }

    private WebElement getToyDetailsRow(String toyName) {
        toyName = " " + toyName + " ";
        return driver.findElement(By.xpath("//tr[.//td[text()=\"" + toyName + "\"]]"));
    }

    public String getQuanitityOnCartPage(String productname) {
        WebElement productDetailRow = getToyDetailsRow(productname);
        WebElement quantity = productDetailRow
                .findElement(By.xpath("./td[contains(@class,'mat-column-quantity' )]/input"));
        return quantity.getAttribute("ng-reflect-value");
    }

    public String getPriceOnCartPage(String productname) {
        WebElement productDetailRow = getToyDetailsRow(productname);
        WebElement eachPrice = productDetailRow.findElement(By.xpath("./td[contains(@class,'mat-column-price')]"));
        return eachPrice.getText();
    }

    public String getSubTotalOnCartPage(String productname) {
        WebElement productDetailRow = getToyDetailsRow(productname);
        WebElement subtotal = productDetailRow.findElement(By.xpath("./td[contains(@class,'mat-column-subtotal')]"));
        return subtotal.getText();
    }

    public String getTotalCost() {
        String total = totalCost.getText();
        return total;
    }

    public void checkout() {
        driver.findElement(By.xpath(("//*[text()=' Check Out']"))).click();
    }
}
