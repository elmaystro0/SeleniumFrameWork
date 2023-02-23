package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage homeObject;
	ProductDetailsPage DetailsObject;
	SearchPage SearchObject;
	String ProductName = "Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void UserCanChangecurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();
		DetailsObject = new ProductDetailsPage(driver);
	}
	@Test(priority = 2)
	public void UserCanSearchByAutoSuggestion()
	{
		try {
			SearchObject = new SearchPage(driver);
			SearchObject.SearchProductUsingAutoSuggest("mac");
			DetailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(DetailsObject.ProductAddressName.getText(), ProductName);
			Assert.assertTrue(DetailsObject.CurrencyType.getText().contains("€"));
			System.out.println(DetailsObject.CurrencyType.getText());
		} catch (InterruptedException e) {
			System.out.println("error Occured : " + e.getMessage());
		}

	}
}
