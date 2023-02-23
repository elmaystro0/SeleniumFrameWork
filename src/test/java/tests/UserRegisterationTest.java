package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully ()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration("Mohamed", "Salama", "testmail100@gmail.com", "123456789");
		Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully")
	public void RegisteredUserCanLogin()
	{
		LoginObject = new LoginPage(driver);
		HomeObject.OpenLoginPage();
		LoginObject.UserLogin("testmail100@gmail.com", "123456789");
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
	}
}
