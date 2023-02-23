package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase
{
	String ProductName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage DetailsObject;
	
	@Test
	public void UserCanSearchForaProduct()
	{
		SearchObject = new SearchPage(driver);
		SearchObject.ProductSearch(ProductName);
		DetailsObject = new ProductDetailsPage(driver);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(DetailsObject.ProductAddressName.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(DetailsObject.ProductAddressName.getText(), ProductName);
	}
}
