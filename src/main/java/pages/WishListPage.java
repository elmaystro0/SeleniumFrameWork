package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "addtocart")
	WebElement AddToCartBTN;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
	WebElement RemoveItemBTN;
	
	@FindBy(css = "h1")
	public WebElement WishListHeader;
	
	@FindBy (css = "div.no-data")
	public WebElement WishListisEmpty;
	
	@FindBy(css = "a.product-name")
	public WebElement ProductCell;
	
	ProductDetailsPage detailsObject;
	
	public void removefromwishlist()
	
	{
		ClickButton(RemoveItemBTN);
	}

}
