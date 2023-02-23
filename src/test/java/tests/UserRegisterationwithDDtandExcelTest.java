package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDtandExcelTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] UserRegisterData() throws IOException
	{
		// get the dat from Excel Reader Class
		ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
	}
	@Test (priority = 1, dataProvider = "ExcelData", alwaysRun = true)
	public void UserCanRegisterSuccssfully(String FirstNameTXT, String LastNameTXT, String EmailTXT, String PasswordTXT) 
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstNameTXT, LastNameTXT, EmailTXT, PasswordTXT);
		
		Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = "RegisteredUserCanLogin", enabled = false)
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully", dataProvider = "ExcelData", enabled = false)
	public void RegisteredUserCanLogin(String FirstNameTXT, String LastNameTXT, String EmailTXT, String PasswordTXT)
	{
		LoginObject = new LoginPage(driver);
		HomeObject.OpenLoginPage();
		LoginObject.UserLogin(EmailTXT, PasswordTXT);
		Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
	}
}
