package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProducttoCompareTest extends TestBase {
	/*
	 * search for 1st product
	 * add to compare list
	 * search for 2nd product
	 * add to compare list
	 * assertion
	 */
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ComparePage CompareObject;
	String FirstProductName = "Apple MacBook Pro 13-inch";
	String SecondProductName= "Asus N551JK-XO076H Laptop";

	
	@Test(priority = 1)
	public void searchfor1stproductandaddtocompare() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.SearchProductUsingAutoSuggest("mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductAddressName.getText().contains(FirstProductName));
		detailsObject.AddtoCompare();
	}
	
	@Test(priority = 2)
	public void searchfor2ndProductandaddtocompare() throws InterruptedException
	{
		searchObject.SearchProductUsingAutoSuggest("asus");
		Assert.assertTrue(detailsObject.ProductAddressName.getText().contains(SecondProductName));
		detailsObject.AddtoCompare();
	}
	@Test(priority = 3)
	public void OpenCompareList()
	{
		detailsObject.OpenComparePageLink();
	}
	@Test(priority = 4)
	public void CompareProducts()
	{
		CompareObject = new ComparePage(driver);
		CompareObject.CompareProducts();
	}
	@Test(priority = 5)
	public void ClearCompareList()
	{
		CompareObject = new ComparePage(driver);
		CompareObject.CleartheCompareList();
	}

}
