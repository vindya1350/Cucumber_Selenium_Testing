package com.jupitertoys.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.jupitertoys.factory.World;
import com.jupitertoys.pages.ShopPage;
import com.jupitertoys.testData.PurchasedProductDetails;
import com.jupitertoys.testData.ToyDetails;

import io.cucumber.java.en.And;

public class ShopPageSteps extends BaseSteps {
    ShopPage shopPage;

    public ShopPageSteps(World world) {
        super(world);
        shopPage = new ShopPage(world.driver);
    }

    @And("I buy following items")
    public void iBuyFollowingItems(List<Map<String, String>> productList) {
        for (Map<String, String> columns : productList) {
            String productName = columns.get("Product");
            world.addProductDetails(new PurchasedProductDetails(productName, columns.get("Count")));
            int count = Integer.parseInt(columns.get("Count"));
            ToyDetails toyDetail = shopPage.getToyDetail(productName);
            for (int i = 0; i < count; i++) {
                shopPage.clickOnBuyButton(toyDetail);
            }
        }
    }
}
