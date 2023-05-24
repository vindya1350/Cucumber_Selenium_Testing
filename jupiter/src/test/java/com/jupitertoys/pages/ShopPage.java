package com.jupitertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jupitertoys.testData.ToyDetails;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ToyDetails getToyDetail(String toyName) {
        ToyDetails toyDetail = new ToyDetails();
        WebElement toyContainer = getToyContainer(toyName);
        if (toyContainer != null) {
            toyDetail.setTitle(toyContainer.findElement(By.cssSelector("h4")).getText());
            String priceText = toyContainer.findElement(By.cssSelector(".product-price")).getText();
            toyDetail.setPrice(Double.parseDouble(priceText.replaceAll("[^\\d.]", "")));
        } else {
            throw new RuntimeException("No toy was found with the name" + toyName);
        }
        return toyDetail;
    }

    private WebElement getToyContainer(String toyName) {
        return driver.findElement(By.xpath("//li[.//h4[text()=\"" + toyName + "\"]]"));
    }

    public void clickOnBuyButton(ToyDetails toy) {
        WebElement toyContainer = getToyContainer(toy.getTitle());
        if (toyContainer != null) {
            toyContainer.findElement(By.xpath(".//a[text()=\"Buy\"]")).click();
        } else {
            throw new RuntimeException("No toy was found with the name" + toy.getTitle());
        }
    }
}
