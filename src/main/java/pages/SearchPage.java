package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement SearchTextBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement SearchBTN;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> AutoSuggestList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement ProductTitle;
	
	public void ProductSearch(String ProductName)
	{
		ElementTextFill(SearchTextBox, ProductName);
		ClickButton(SearchBTN);
	}
	public void openProductDetailsPage()
	{
		ClickButton(ProductTitle);
	}
	public void SearchProductUsingAutoSuggest(String Searchtxt) throws InterruptedException
	{
		ElementTextFill(SearchTextBox, Searchtxt);
		Thread.sleep(3000);
		AutoSuggestList.get(0).click();
	}
}
