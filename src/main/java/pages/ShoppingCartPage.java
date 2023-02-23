package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "updatecart")
	WebElement RemoveProductFromShoopingCart;
	
	@FindBy(id = "updatecart")
	WebElement UpdateShoppingCart;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")
	public WebElement ItemQuantinty;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement Total;
	
	@FindBy(id = "checkout")
	WebElement CheckOutBTN;
	
	@FindBy(id = "termsofservice")
	WebElement ChecktermsandConditions;
	
	public void RemoveItemFromShoppingCart() 
	{
		ClickButton(RemoveProductFromShoopingCart);
	}
	public void UpdateProductQuantityinShoppingCart(String QuantityNumberTXT)
	{
		ClearText(ItemQuantinty);
		ElementTextFill(ItemQuantinty, QuantityNumberTXT);
		ClickButton(UpdateShoppingCart);
	}
	public void CheckOuttheProduct()
	{
		ClickButton(ChecktermsandConditions);
		ClickButton(CheckOutBTN);
	}

}
