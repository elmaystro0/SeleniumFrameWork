package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	
	/*
	 * search for product
	 * add to wishlist
	 * remove from wishlist
	 * assert wish cart is empty
	 */

	SearchPage searchobject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	String ProductName = "Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void UserCanSearchforaProduct()
	{
		searchobject = new SearchPage(driver);
		searchobject.ProductSearch(ProductName);
		searchobject.openProductDetailsPage();
	}
	@Test(priority = 2)
	public void AddItemToWishListTest()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToWishList();
		wishlistObject = new WishListPage(driver);
		Assert.assertTrue(wishlistObject.WishListHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.ProductCell.getText().contains(ProductName));
	}
	
	@Test(priority = 3)
	public void addtowhishlisttest()
	{
		wishlistObject = new WishListPage(driver);
		wishlistObject.removefromwishlist();
		Assert.assertTrue(wishlistObject.WishListisEmpty.getText().contains("empty"));
	}

}
