@smoke
Feature: Retail Account Page

Background:
	Given User is on retail website homepage
	When User click on the login link
	And User enter email 'student20@tekschool.us' and password 'Student@20'
	And User click on login button
	Then Verify user is logged in

@updatePI
Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Mostudent' and Phone '5105105100'
    And User click on Update button
    Then user profile information should be updated

@addPaymentMethod
Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
    |cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
    |1121322243334555|Guardians|11|2025|541|
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'
    @EditCreditCard
   Scenario: Verify User can edit Debit or Credit card
    When User click on Account optio
    And User click on card And accounts 
    And User click on Edit option of card section
    And User edit Debit or Credit card information
    |cardNumber       |nameOnCard|expirationMonth|expirationYear|securityCode|
    |11213222433340011|Mostudent |   12          |2028         |   117     |
    And User click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully' 
    
    @removeDorCCard
    Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed
    
@addAddress
Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |countryValue|fullnameValue|PhoneValue|stAddress|aptValue|cityValue|stateValue|zipCodeValue|
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'
   @editAddress 
    Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |countryValue|fullnameValue|PhoneValue|stAddress|aptValue|cityValue|stateValue|zipCodeValue|
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'
  @removeAddress  
    Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed