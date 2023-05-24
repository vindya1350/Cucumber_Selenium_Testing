package com.jupitertoys.stepDefinitions;

import com.jupitertoys.factory.World;
import com.jupitertoys.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class NavigationStep extends BaseSteps {
    
    HomePage homePage;
    
    public NavigationStep(World world) {
        super(world);
        homePage = new HomePage(world.driver);
    }

    @When("I navigate to contact Page")
    public void iNavigateToContactPage() {
        homePage.clickOnContactMenu();
    }

    @When("I am in shop page")
    public void iAmInShopPage() {
        homePage.clickOnShopMenu();
    }

    @And("I navigate to cart page")
    public void iNavigateToCartPage() {
        homePage.clickOnCartMenu();
    }
}
