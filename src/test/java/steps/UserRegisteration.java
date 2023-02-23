package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;

	@Given("The User is in the home page")
	public void the_user_is_in_the_home_page() {
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
	}
	@When("I click on Register Link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entere the User Data") public void i_entere_the_user_data() {
	 * RegisterObject = new UserRegisterationPage(driver);
	 * RegisterObject.UserRegisteration("Mohamed", "Salama", "test06@testing.com",
	 * "123456789");
	 }*/
	@When("I entere {string}, {string}, {string}, {string}")
	public void i_entere(String FirstName, String LastName, String Email, String Password) {
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstName, LastName, Email, Password);

	}

	@Then("The Registeration page displayed Successfully")
	public void the_registeration_page_displayed_successfully() {
		//RegisterObject.UserLogout();
	}


}
