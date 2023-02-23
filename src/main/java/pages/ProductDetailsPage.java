package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "strong.current-item")
	public WebElement ProductAddressName;
	
	@FindBy(css = "span.price-value-4")
	public WebElement CurrencyType;
	
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement EmailFriendLinkBTN;
	
	@FindBy(linkText = "Add your review")
	WebElement AddReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement AddtoWishListLink;
	
	@FindBy(css = "span.wishlist-label")
	WebElement WishListLink;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddtoCompareBTN;
	
	@FindBy (xpath = "/html/body/div[5]/div/p/a")
	WebElement ComparePageLink;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddtoCartBTN;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]")
	WebElement OpenShoppingCartLink;
	
	public void openSendEmail()
	{
	 ClickButton(EmailFriendLinkBTN);
	}
	public void OpenAddReviewPage()
	{
		ClickButton(AddReviewLink);

	}
	public void AddToWishList()
	{
		ClickButton(AddtoWishListLink);
		ClickButton(WishListLink);
	}
	public void AddtoCompare()
	{
		ClickButton(AddtoCompareBTN);
	}
	public void OpenComparePageLink()
	{
		ClickButton(ComparePageLink);
	}
	public void AddProductToCart()
	{
		ClickButton(AddtoCartBTN);
	}
	public void OpenShoppingCart()
	{
		ClickButton(OpenShoppingCartLink);
	}

}
