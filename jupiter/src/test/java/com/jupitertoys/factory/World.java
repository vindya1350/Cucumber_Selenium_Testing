package com.jupitertoys.factory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.jupitertoys.testData.PurchasedProductDetails;

public class World {

    public WebDriver driver;
    private PurchasedProductDetails purchasedProductDetails;
    private String contactName;

    public World() {
    }

    private List<PurchasedProductDetails> productList = new ArrayList<>();
    
    public void addProductDetails(PurchasedProductDetails productDetails) {
        productList.add(productDetails);
    }
    
    public List<PurchasedProductDetails> getPurchasedProductDetails() {
        return productList;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

}
