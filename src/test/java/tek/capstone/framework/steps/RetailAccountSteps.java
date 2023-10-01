package tek.capstone.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.capstone.framework.pages.POMFactory;
import tek.capstone.framework.utilities.CommonUtility;
import tek.capstone.framework.utilities.DataGenerator;
import tek.capstone.framework.utilities.DataGeneratore2;

public class RetailAccountSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountLink);
		logger.info("Account link was clicked successfully");
		
	}
	
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		sendText(pomFactory.retailAccountPage().nameField, name);
		logger.info("Name was entered successfully");
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneField);
		sendText(pomFactory.retailAccountPage().phoneField, DataGeneratore2.getPhoneNumber());
		logger.info("Phone Number was entered successfully");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBttn);
		logger.info("Update button was clicked successfully");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Account information was updated successfully");
	}

	// Add payment
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addAPaymentMethodLink);
		logger.info("Add Payment Method link was clicked successfully");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailAccountPage().cardNumberField, DataGeneratore2.getCardNumber());
		sendText(pomFactory.retailAccountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonthField,
				paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expireationYearField,
				paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));

		logger.info("Payment Information was entered successfully");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {

		if (expectedMssg.contains("Payment Method added")) {
			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} else if (expectedMssg.contains("Order Placed")) {
			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessMsg);
			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessMsg.getText());
//		} else if (expectedMssg.contains("Payment Method updated")) {
//			waitTillPresence(pomFactory.retailAccountPage().editCriditCardMassgSuccesfull);
//			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().editCriditCardMassgSuccesfull.getText());
//			
			} else if (expectedMssg.contains("Address Updated Successfully")) {
			waitTillPresence(pomFactory.retailAccountPage().udateSuccesAddressMassg);
			 Assert.assertEquals(expectedMssg,pomFactory.retailAccountPage().udateSuccesAddressMassg.getText());
		}

	}

	// Edit Payment
	@When("User click on Account optio")
	public void userClickOnAccountOptio() {
		click(pomFactory.retailAccountPage().accountLink);
	}

	@When("User click on card And accounts")
	public void userClickOnCardAndAccounts() {
		click(pomFactory.retailAccountPage().cardsAndAccounts);
	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(pomFactory.retailAccountPage().editBttn);
		logger.info("User click on Edit button");
	}

	@When("User edit Debit or Credit card information")
	public void userEditDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> editPaymentInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cardNumberField);
		sendText(pomFactory.retailAccountPage().cardNumberField, DataGeneratore2.getCardNumber());
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameOnCardField);
		sendText(pomFactory.retailAccountPage().nameOnCardField, editPaymentInfo.get(0).get("nameOnCard"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().expirationMonthField);
				
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonthField,
				editPaymentInfo.get(0).get("expirationMonth"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().expireationYearField);
		
		selectByVisibleText(pomFactory.retailAccountPage().expireationYearField, editPaymentInfo.get(0).get("expirationYear"));

		clearTextUsingSendKeys(pomFactory.retailAccountPage().securityCodeField);
		sendText(pomFactory.retailAccountPage().securityCodeField, editPaymentInfo.get(0).get("securityCode"));
		logger.info("Payment information edited suuscefully");

	}

	@When("User click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.retailAccountPage().editUpdateBttn);
		logger.info("User click on Update button succesfully");
	}
	
	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
	    waitTillPresence(pomFactory.retailAccountPage().editCriditCardMassgSuccesfull);
	    String actual = pomFactory.retailAccountPage().editCriditCardMassgSuccesfull.getText();
	    String expected = "Payment Method updated Successfully";
	    Assert.assertEquals(actual, expected);
	    logger.info("payment update msg displayed successfully");
	}
	// removeCard
		@And("User click on remove option of card section")
		public void userClickOnRemoveOptionOfCardSection1() {
			click(pomFactory.retailAccountPage().paymentList);
			click(pomFactory.retailAccountPage().removeBttn);
			logger.info("card remove button clicked successfully");
		}

		@Then("payment details should be removed")
		public void paymentDetailsShouldBeRemoved1() {
			Assert.assertTrue(pomFactory.retailAccountPage().addCardHeader.isDisplayed());
			logger.info("payment card removed successfully.");
		}


	// add Address
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("Add Address Link was clicked successfully");
	}

	
	

	
	// add address
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		
		selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressNameField);
		sendText(pomFactory.retailAccountPage().addressNameField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressPhoneField);
		sendText(pomFactory.retailAccountPage().addressPhoneField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStreetField);
		sendText(pomFactory.retailAccountPage().addressStreetField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressApartmentNum);
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressCityField);
		sendText(pomFactory.retailAccountPage().addressCityField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStateDropdown);
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().addressZipCodeField);
		sendText(pomFactory.retailAccountPage().addressZipCodeField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));

		logger.info("Address form was filled out successfully");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Add Address Button was clicked successfully");
	}
	// Edit Address

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(pomFactory.retailAccountPage().editAddressOption);
		logger.info("user click on edit address");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(pomFactory.retailAccountPage().updateAddresBttn);
		logger.info("user click on update button");
	}

	// Remove Address

	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		scrollPageDownWithJS();
		click(pomFactory.retailAccountPage().RemoveAddressBtn);
		logger.info("remove address button clicked");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertNotNull(pomFactory.retailAccountPage().firstAddressBox);
		logger.info("address details removed");
	}

}