package tek.capstone.framework.steps;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.framework.pages.POMFactory;
import tek.capstone.framework.utilities.CommonUtility;
import tek.capstone.framework.utilities.DataGeneratore2;

public class LoginSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	
	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {
		Assert.assertTrue(pomFactory.homePage().tekschoolLogo.isDisplayed());
		logger.info("TEKSCHOOL logo is displayed");
	}
	
	@When("User click on the login link")
	public void userClickOnTheLoginLink() {
		click(pomFactory.loginPage().signInLink);
		logger.info("Login Link was clicked successfully");
	}
	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.loginPage().emailField, email);
		sendText(pomFactory.loginPage().passwordField, password);
		logger.info("Email and Password were entered successfully");
	}
	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.loginPage().loginBttn);
		logger.info("Login button was clicked successfully");
	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(pomFactory.loginPage().logoutBttn.isDisplayed());
	logger.info("user is logged in");
	}
	//register
	@When("User click on create new account link")
	public void userClickOnCreateNewAccountLink() {
		click(pomFactory.loginPage().newAccountBttn);
		logger.info("Create new account bttn clicked successfully");
	}
	@When("User enter {string} and {string} and {string} and {string}")
	public void userEnterAndAndAnd(String name, String email, String password, String confPassword) {
		sendText(pomFactory.loginPage().nameInputField, name);
		sendText(pomFactory.loginPage().emailInputField, DataGeneratore2.emailGenerator());
		sendText(pomFactory.loginPage().passwordInputField, password);
		sendText(pomFactory.loginPage().confirmPassInputField, confPassword);
		logger.info("User information was entered successfully");
	}
	@When("User click on singup button")
	public void userClickOnSingupButton() {
		click(pomFactory.loginPage().signupBttn);
		logger.info("Signup button was clicked sucessfully");
	}
	@Then("Verify user account is created")
	public void verifyUserAccountIsCreated() {
		Assert.assertTrue(pomFactory.loginPage().yourProfileText.isDisplayed());
		logger.info("User account is created successfully");
	}

}
