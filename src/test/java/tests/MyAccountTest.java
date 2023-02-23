package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage RegisterationObject;
	LoginPage LoginObject;
	MyAccountPage MayAccountObject;
	String FirstName = "Mohamed ";
	String LastName = "Salama";
	String Password = "123456789";
	String NewPassword = "987654321";
	String Email = "tusaaswa@tesft.com";

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccsefullty()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		RegisterationObject = new UserRegisterationPage(driver);
		RegisterationObject.UserRegisteration(FirstName, LastName, Email, Password);
		Assert.assertTrue(RegisterationObject.Registerationdone.getText().contains("completed"));
	}
	@Test (dependsOnMethods = "UserCanRegisterSuccsefullty")
	public void UserCanLoginSuccessfully()
	{
		LoginObject = new LoginPage(driver);
		homeObject.OpenLoginPage();
		LoginObject.UserLogin(Email, Password);
	}
	@Test(dependsOnMethods = "UserCanLoginSuccessfully")
	public void UserChangePasswordSuccessfully() throws InterruptedException
	{
		MayAccountObject = new MyAccountPage(driver);
		RegisterationObject.OpenMyAccountPage();
		MayAccountObject.OpenChangePasswordPage();
		MayAccountObject.ChangePassword(Password, NewPassword);
		Assert.assertTrue(MayAccountObject.PasswordChangedSuccesfully.getText().contains("changed"));
		MayAccountObject.CloseNotification();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = "UserChangePasswordSuccessfully")
	public void UserCanLogOutAfterChangePassword()
	{
		MayAccountObject.Logout();
	}
	@Test (dependsOnMethods = "UserCanLogOutAfterChangePassword")
	public void UserCanLoginWithTheNewPassword()
	{
		homeObject.OpenLoginPage();
		LoginObject.UserLogin(Email, NewPassword);
	}




}
