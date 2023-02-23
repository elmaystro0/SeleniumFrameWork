package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandDataProviderTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	
	@DataProvider(name = "TestRegisterationData")
	public static Object [][] UserRegisterationData ()
	{
		return new Object [][] 
				{
			{
				"Mohamed", "Salama", "test03@testing.com", "123456789"},
			{"Ahmed", "Sayed", "test04@testing.com", "123456789"}
				};
	}
	@DataProvider (name = "TestLoginData")
	public static Object [][] UserLoginData()
	{
		return new Object [][]
				{
			{"test03@testing.com", "123456789"},{
				"test04@testing.com", "123456789"}
				};
	}

	@Test (priority = 1, dataProvider = "TestRegisterationData")
	public void UserCanRegisterSuccssfully (String FirstNameTXT, String LastNameTXT, String EmailTXT, String PasswordTXT) throws InterruptedException
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstNameTXT, LastNameTXT,EmailTXT,PasswordTXT);
		Thread.sleep(3000);
		Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = "RegisteredUserCanLogin", enabled = false)
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully", dataProvider = "TestLoginData")
	public void RegisteredUserCanLogin(String EmailTXt, String PasswordTXT) throws InterruptedException
	{
		LoginObject = new LoginPage(driver);
		HomeObject.OpenLoginPage();
		
		LoginObject.UserLogin(EmailTXt, PasswordTXT);
		Thread.sleep(3000);
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
		RegisterObject.UserLogout();
	}
}
