package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase{
	
	/*
	 * 1- User Register Successfully
	 * 2- User Login
	 * 3- USer Search For Product
	 * 4- User Add Review
	 * 5- User Log out
	 */
	
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	SearchPage SearchObject;
	ProductReviewPage ReviewObject;
	ProductDetailsPage DetailsObject;
	String FirstNameTXT = "Mohamed";
	String LastNameTXT = "Salama";
	String EmailTXT = "test@testing.com";
	String PasswordTXT = "123456789";
	String ProductNameTXT = "Apple MacBook Pro 13-inch";
	String ReviewtitleTXT = "Test";
	String ReviewMessageTXT = "Testing Review";
	
	@Test (priority =  1, alwaysRun = true)
	public void UserRegisterSuccessfully()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterationPage();
		RegisterObject = new UserRegisterationPage(driver);
		RegisterObject.UserRegisteration(FirstNameTXT, LastNameTXT, EmailTXT, PasswordTXT);
	}
	@Test(priority = 2)
	public void UserLoginSuccessfully()
	{
		HomeObject.OpenLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(EmailTXT, PasswordTXT);
	}
	@Test (priority = 3)
	public void UserCanSearchForAProduct()
	{
		try {
			SearchObject = new SearchPage(driver);
			SearchObject.SearchProductUsingAutoSuggest("Mac");
			
		} catch (InterruptedException e) {
			System.out.println("Error Occured : " + e.getMessage());
		};
	}
	@Test (priority = 4)
	public void UserCanAddReview()
	{
		DetailsObject.OpenAddReviewPage();
		ReviewObject = new ProductReviewPage(driver);
		ReviewObject.AddProductReview(ReviewtitleTXT, ReviewMessageTXT);
		Assert.assertTrue(ReviewObject.ReviewaddedSuccessfully.getText().contains("review"));
	}
	
	@Test(priority = 5)
	public void UserCanLogout()
	{
		RegisterObject.UserLogout();
	}

}
