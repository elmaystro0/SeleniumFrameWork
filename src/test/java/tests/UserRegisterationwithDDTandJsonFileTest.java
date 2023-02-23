package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandJsonFileTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	JsonDataReader JsonReader = new JsonDataReader();
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully () throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader JsonReader = new JsonDataReader();
		JsonReader.JsonReader();
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(JsonReader.FirstName, JsonReader.LastName,JsonReader.Email,JsonReader.Password);
		Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = "RegisteredUserCanLogin", enabled = false)
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully")
	public void RegisteredUserCanLogin() throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader JsonReader = new JsonDataReader();
		JsonReader.JsonReader();
		LoginObject = new LoginPage(driver);
		HomeObject.OpenLoginPage();
		LoginObject.UserLogin(JsonReader.Email, JsonReader.Password);
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
		RegisterObject.UserLogout();
	}
}
