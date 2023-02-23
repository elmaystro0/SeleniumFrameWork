package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTandPropertiesFileTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	String FirstNameTXT = LoadProperties.UserData.getProperty("FirstName");
	String LastNameTXT = LoadProperties.UserData.getProperty("LastName");
	String EmailTXT = LoadProperties.UserData.getProperty("Email");
	String PasswordTXT = LoadProperties.UserData.getProperty("Password");
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully ()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstNameTXT, LastNameTXT, EmailTXT, PasswordTXT);
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
		LoginObject.UserLogin(EmailTXT, PasswordTXT);
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
	}
}
