package com.jupitertoys.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.jupitertoys.factory.World;
import com.jupitertoys.pages.ContactPage;
import com.jupitertoys.testData.FeedbackContactDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPageSteps extends BaseSteps {

    ContactPage contactPage;

    public ContactPageSteps(World world) {
        super(world);
        contactPage = new ContactPage(world.driver);
    }

    List<String> fieldNameList = new ArrayList<>();
    List<String> mandoryErrList = new ArrayList<>();

    @When("I submit contact form")
    public void iSubmitContactFormWithoutFillingAnyMandatoryFields() {
        contactPage.clickSubmitButton();
    }

    @Then("I can see following error messages are populated for Mandatory fields")
    public void I_can_see_following_error_messages_are_populated_for_Mandatory_fields(
            List<Map<String, String>> errorMsgList) {
        for (Map<String, String> msg : errorMsgList) {
            WebElement actulaMsg = contactPage.getMandatoryFieldErrorMsg(msg.get("FieldName"));
            Assert.assertEquals(msg.get("ErrorMsg"), actulaMsg.getText());
            mandoryErrList.add(msg.get("ErrorMsg"));
            fieldNameList.add(msg.get("FieldName"));
        }
    }

    @When("I fill in contact details of feedback form with following details$")
    public void iFillAllMandatoryFiled(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        if (data.size() != 1) {
            throw new IllegalArgumentException("Expected only one set of contact details in the data table.");
        }
        Map<String, String> columns = data.get(0);
        String contactName = columns.get("Name");
        world.setContactName(contactName);
        FeedbackContactDetails contactDetails = new FeedbackContactDetails(
                contactName,
                columns.get("Email"),
                columns.get("TelephoneNo"),
                columns.get("Type"),
                columns.get("Message")
        );
        contactPage.fillForename(contactDetails.getName());
        contactPage.fillEmail(contactDetails.getEmail());
        contactPage.fillTelephone(contactDetails.getTelephoneNo());
        contactPage.selectType(contactDetails.getType());
        contactPage.fillMsg(contactDetails.getMessage());
    }

    @Then("I can not see error messages")
    public void iCanNotSeeErrorMessages() {
        for (int i = 0; i < fieldNameList.size(); i++) {
            Boolean actualMsg = contactPage.isElementVisible(fieldNameList.get(i));
            Assert.assertEquals(actualMsg, false);
        }
    }

    @Then("^I can see success message")
    public void iCanSeeSuccessMessages() {
        String contactName = world.getContactName();
        String expectedMessage = "Thanks " + contactName + ", we appreciate your feedback.";
        String actualSuccessMsg = contactPage.successMsgIsVisible();
        Assert.assertEquals(actualSuccessMsg, expectedMessage);
    }
}
