package com.jupitertoys.stepDefinitions;

import java.text.DecimalFormat;
import java.util.List;
import org.junit.Assert;
import com.jupitertoys.api.ToyAPIEndpoint;
import com.jupitertoys.factory.World;
import com.jupitertoys.pages.CartPage;
import com.jupitertoys.testData.PurchasedProductDetails;
import com.jupitertoys.testData.ToyDetails;

import io.cucumber.java.en.Then;

public class CartPageSteps extends BaseSteps {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    CartPage cartPage;
    ToyAPIEndpoint toyAPIEndpoint = new ToyAPIEndpoint();

    public CartPageSteps(World world) {
        super(world);
        cartPage = new CartPage(world.driver);
    }

    @Then("I can see correct quantity, product and subtotal are correct")
    public void iCanSeeCorrectQuantityAndProductPriceAreCorrect() {
        List<ToyDetails> toys = toyAPIEndpoint.getAllToys();
        List<PurchasedProductDetails> purchasedProductList = world.getPurchasedProductDetails();

        float total = 0;
        for (PurchasedProductDetails productDetails : purchasedProductList) {
            String productName = productDetails.getName();
            Assert.assertTrue(cartPage.verifyProductIsAddedToCart(productName));
            String noOfpurchProduct = productDetails.getQuantity();
            float tempSubTotal = 0;
            for (int j = 0; j < toys.size(); j++) {
                if (toys.get(j).getTitle().equals(productName)) {
                    String toyId = Integer.toString(toys.get(j).getId());
                    ToyDetails toy = toyAPIEndpoint.getToy(toyId); 
                    String expectedSubtotal = String.valueOf(df.format(toy.getPrice() * Integer.parseInt(noOfpurchProduct)));
                    tempSubTotal = Float.parseFloat(expectedSubtotal);
                    Assert.assertEquals("$" + Double.toString(toy.getPrice()), cartPage.getPriceOnCartPage(productName));
                    Assert.assertEquals(noOfpurchProduct, cartPage.getQuanitityOnCartPage(productName));
                    Assert.assertEquals("$" + expectedSubtotal, cartPage.getSubTotalOnCartPage(productName));
                }
            }
            total = total + tempSubTotal;
        }
        String finalTotal = "Total "+String.valueOf(total);
        Assert.assertEquals(cartPage.getTotalCost(), finalTotal);
    }
}
