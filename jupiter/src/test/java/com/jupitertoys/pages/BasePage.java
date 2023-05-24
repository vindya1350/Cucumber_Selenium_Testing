package com.jupitertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver ;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickOnContactMenu() {
        clickOnMore();
        driver.findElement(By.xpath("//button[./*[text()='Contact']]")).click();
    }

    public void clickOnShopMenu() {
        clickOnMenu("Shop");
    }

    public void clickOnCartMenu() {
        clickOnMenu("Cart");
    }

    private void clickOnMenu(String menuName) {
        driver.findElement(By.xpath("//button[.//span[text()=\""+menuName+"\"]]")).click();
    }

    private void clickOnMore() {
        driver.findElement(By.xpath("//*[text()='more_vert']")).click();
    }
    
}
