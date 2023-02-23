package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage DetailsObject;
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		SearchObject = new SearchPage(driver);
		SearchObject.SearchProductUsingAutoSuggest("mac");
		DetailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(DetailsObject.ProductAddressName.getText(),ProductName);
	}

}
