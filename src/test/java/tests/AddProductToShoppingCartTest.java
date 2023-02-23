package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	/*
	 * Search For Product
	 * Add To Cart
	 * update quantity
	 * remove Products from Cart
	 */
	SearchPage SearchObject;
	String ProductName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage DetailsObject;
	HomePage HomeObject;
	ShoppingCartPage cartObject;
	@Test(priority = 1)
	public void SearchForProducts() throws InterruptedException
	{
		SearchObject = new SearchPage(driver);
		SearchObject.SearchProductUsingAutoSuggest("mac");
		DetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(DetailsObject.ProductAddressName.getText().contains(ProductName));
	}
	@Test(priority = 2)
	public void AddProductTotheShoppingCart() throws InterruptedException
	{
		cartObject = new ShoppingCartPage(driver);
		DetailsObject.AddProductToCart();
		Thread.sleep(5000);
		HomeObject = new HomePage(driver);
		DetailsObject.OpenShoppingCart();
		System.out.println(cartObject.Total.getText());
	}
	@Test(priority = 3)
	public void UpdatethequantityofProductinshoppingCart()
	{
		cartObject = new ShoppingCartPage(driver);
		cartObject.UpdateProductQuantityinShoppingCart("5");
		System.out.println(cartObject.Total.getText());
	}
	
	@Test(priority = 4)
	public void RemoveProductsFromTheshoppingCart()
	{
		cartObject.RemoveItemFromShoppingCart();
	}
}
