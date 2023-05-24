package com.jupitertoys.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.jupitertoys.factory.World;
import com.jupitertoys.pages.CartPage;
import com.jupitertoys.pages.CheckoutContactDetailsPage;
import com.jupitertoys.pages.CheckoutDeliveryDetailsPage;
import com.jupitertoys.pages.CheckoutConfirmOrderPage;
import com.jupitertoys.pages.CheckoutPaymentDetailsPage;
import com.jupitertoys.testData.DeliveryContactDetails;
import com.jupitertoys.testData.PaymentDetails;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPageSteps extends BaseSteps {
    CheckoutConfirmOrderPage checkoutConfirmOrderPage;
    CartPage cartPage;
    CheckoutContactDetailsPage checkoutContactDetailsPage;
    CheckoutDeliveryDetailsPage checkoutDeliveryDetailsPage;
    CheckoutPaymentDetailsPage checkoutPaymentDetailsPage;
    DeliveryContactDetails deliveryContactDetails;

    public CheckoutPageSteps(World world) {
        super(world);
        checkoutConfirmOrderPage = new CheckoutConfirmOrderPage(world.driver);
        cartPage = new CartPage(world.driver);
        checkoutContactDetailsPage = new CheckoutContactDetailsPage(world.driver);
        checkoutDeliveryDetailsPage = new CheckoutDeliveryDetailsPage(world.driver);
        checkoutPaymentDetailsPage = new CheckoutPaymentDetailsPage(world.driver);
    }

    @When("I do checkout")
    public void i_do_checkout() {
        cartPage.checkout();
    }

    @When("I fill in contact details section in checkoutPage with following details")
    public void i_fill_in_contact_details_section_in_checkout_page_with_following_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> column : data) {
            deliveryContactDetails = new DeliveryContactDetails(
                    column.get("FirstName"),
                    column.get("LastName"),
                    column.get("Email"),
                    column.get("TelephoneNo"),
                    column.get("Address"),
                    column.get("Suburb"),
                    column.get("State"),
                    column.get("PostCode"));
        }
        checkoutContactDetailsPage.fillFirstName(deliveryContactDetails.getFirstname());
        checkoutContactDetailsPage.fillLastName(deliveryContactDetails.getLastName());
        checkoutContactDetailsPage.fillEmail(deliveryContactDetails.getEmail());
        checkoutContactDetailsPage.fillPhoneNo(deliveryContactDetails.getPhoneNo());
        checkoutContactDetailsPage.fillContactAddress(deliveryContactDetails.getAddressline1());
        checkoutContactDetailsPage.fillContactSuburb(deliveryContactDetails.getSuburb());
        checkoutContactDetailsPage.selectState(deliveryContactDetails.getState());
        checkoutContactDetailsPage.fillContactPostCode(deliveryContactDetails.getPostCode());
    }

    @When("I navigate to delivery details section")
    public void i_navigate_to_delivery_details_section() {
        checkoutContactDetailsPage.navigateToDeliveryDetailsSection();
    }

    @When("I provide Yes for Same as Contact Address field")
    public void i_provide_above_same_contact_details_for_delivery_details_section() {
        checkoutDeliveryDetailsPage.usesameContactDetailsAsDeliveryDetails();
    }

    @Then("I can see given contact details are filled as delivery details")
    public void i_can_see_given_contact_details_are_filled_as_delivery_details() {
        Map<String, String> filledDeliveryDetails = checkoutDeliveryDetailsPage.getDeliveryDetails();
        String expectedName = deliveryContactDetails.getFirstname() + " " + deliveryContactDetails.getLastName();
        Assert.assertEquals(expectedName, filledDeliveryDetails.get("Name"));
        Assert.assertEquals(deliveryContactDetails.getAddressline1(), filledDeliveryDetails.get("AddressLine1"));
        Assert.assertEquals(deliveryContactDetails.getSuburb(), filledDeliveryDetails.get("Suburb"));
        Assert.assertEquals(deliveryContactDetails.getState(), filledDeliveryDetails.get("State"));
        Assert.assertEquals(deliveryContactDetails.getPostCode(), filledDeliveryDetails.get("PostCode"));
    }

    @When("I navigate to payment details section")
    public void i_navigate_to_payment_details_section() {
        checkoutDeliveryDetailsPage.navigateToPaymentDetailsSection();
    }

    @When("I fill payment detail section")
    public void i_fill_payment_details() {
        PaymentDetails paymentDetails = new PaymentDetails();
        checkoutPaymentDetailsPage.fillCardNumber(paymentDetails.getCardNumber());
        checkoutPaymentDetailsPage.selectCardType(paymentDetails.getCardType());
        checkoutPaymentDetailsPage.fillCardName(paymentDetails.getNameOnCard());
        checkoutPaymentDetailsPage.fillExpiryDate(paymentDetails.getExpiryDate());
        checkoutPaymentDetailsPage.fillCvvNumber(paymentDetails.getCvv());
    }

    @When("I navigate to order confirmation details section")
    public void i_navigate_to_order_confirmation_section() {
        checkoutPaymentDetailsPage.navigateToConfirmOrderSection();
    }

    @When("I submit the order")
    public void i_submit_the_order() {
        checkoutConfirmOrderPage.submitOrder();
    }

    @Then("I can see order getting unsuccessfull")
    public void i_can_see_order_getting_unsuccessfull() {
        String failMsg = checkoutConfirmOrderPage.unsuccessMsgIsVisible();
        System.out.println("fail msg is "+failMsg);
        Assert.assertEquals("Payment Failed", failMsg);
    }
}
