package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage CartObject;
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
	}
	@When("Customer will press on register link and enter {string}, {string}, {string}, {string}")
	public void customer_will_press_on_register_link_and_enter
	(String FirstName, String LastName, String Email, String Password) {
	    HomeObject = new HomePage(driver);
	    HomeObject.OpenRegisterationPage();
	    RegisterObject = new UserRegisterationPage(driver);
	    RegisterObject.UserRegisteration(FirstName, LastName, Email, Password);
	}
	@When("Customer will login Using the data {string}, {string}")
	public void customer_will_login_using_the_data(String Email, String Password) {
	    HomeObject.OpenLoginPage();
	    LoginObject = new LoginPage(driver);
	    LoginObject.UserLogin(Email, Password);
	}
	@When("Customer will Search For Prouct {string}")
	public void customer_will_search_for_prouct(String ProductName) throws InterruptedException {
	    SearchObject = new SearchPage(driver);
	    SearchObject.SearchProductUsingAutoSuggest(ProductName);
	}
	@When("Customer will add to Shopping Cart")
	public void customer_will_add_to_shopping_cart() {
	    detailsObject = new ProductDetailsPage(driver);
	    detailsObject.AddProductToCart();
	}
	@Then("Item will be displayed in the shopping Cart")
	public void item_will_be_displayed_in_the_shopping_cart() {
	   detailsObject.OpenShoppingCart();
	   CartObject = new ShoppingCartPage(driver);
	   System.out.println(CartObject.Total.getText());
	   RegisterObject.UserLogout();
	}

}
