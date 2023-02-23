package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {

	// 4 steps to be Done
	// 1- User Registeration
	// 2- USerLogin
	// 3- Search for Product
	// 4- email a friend 
	// 5- USerCan Logout
	HomePage HomeObject;
	UserRegisterationPage RegisterationObject;
	LoginPage LogindObject;
	SearchPage SearchObject;
	ProductDetailsPage DetailsObject;
	EmailPage EmailObject;
	String ProductName = "Apple MacBook Pro 13-inch";
	LoginPage LoginObject;
	String FirstNameTXT = "Mohamed";
	String LastNAmeTXT = "Salama";
	String EmailTXT = "sdasasa@jass.com";
	String PasswotdTXT = "123456789";
	@Test (priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterationObject = new UserRegisterationPage(driver);
		RegisterationObject.UserRegisteration(FirstNameTXT, LastNAmeTXT, EmailTXT, PasswotdTXT);
		Assert.assertTrue(RegisterationObject.Registerationdone.getText().contains("completed"));
	}
	@Test (priority = 2)
	public void UserCanLogin()
	{
		HomeObject.OpenLoginPage();
		LogindObject = new LoginPage(driver);
		LogindObject.UserLogin(EmailTXT, PasswotdTXT);
	}
	@Test (priority = 3)
	public void USerCanSearchForProductwithAutoSuggest()
	{
		try {
			SearchObject = new SearchPage(driver);
			SearchObject.SearchProductUsingAutoSuggest("Mac");
			DetailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(DetailsObject.ProductAddressName.getText(), ProductName);
		} catch (InterruptedException e) {
			System.out.println("Erro Occured +  "+ e.getMessage());			
		}
	}
	@Test(priority = 4)
	public void UserCanSendaProductToaFriend()
	{
		DetailsObject.openSendEmail();
		EmailObject = new EmailPage(driver);
		EmailObject.SendEmail("saddsa@odk.com", "Hello My Friend");
		Assert.assertTrue(EmailObject.Result.getText().contains("been sent"));
	}
	@Test (priority = 5)
	public void UserCanLogOut()
	{
		RegisterationObject = new UserRegisterationPage(driver);
		RegisterationObject.UserLogout();
	}


}
