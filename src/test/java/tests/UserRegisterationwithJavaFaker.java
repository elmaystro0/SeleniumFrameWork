package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithJavaFaker extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	Faker fakedata = new Faker();
	String FirstName = fakedata.name().firstName();
	String LastName = fakedata.name().lastName();
	String Email = fakedata.internet().emailAddress();
	String Password = fakedata.number().digits(9).toString();
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully ()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstName,LastName,Email,Password);
		System.out.println(FirstName + "\n" + LastName + "\n" + Email + "\n" + Password);
		Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully")
	public void RegisteredUserCanLogin()
	{
		LoginObject = new LoginPage(driver);
		HomeObject.OpenLoginPage();
		LoginObject.UserLogin(Email,Password);
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
	}
	
	@Test (dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
}
