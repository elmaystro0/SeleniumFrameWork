package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/a")
	WebElement ClearList;

	@FindBy (css = "div.no-data")
	public WebElement AllItemsCleared;

	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;

	@FindBy(tagName = "tr")
	public List<WebElement> AllRows;

	@FindBy(tagName = "td")
	public List<WebElement> AllColmuns;

	public void CleartheCompareList()
	{
		ClickButton(ClearList);
	}
	public void CompareProducts()
	{
		// get all rows
		System.out.println(AllRows.size());
		// get data of each row
		for (WebElement row : AllRows) 
		{
			System.out.println(row.getText()+ "\t");
		}
		for (WebElement Col : AllColmuns) 
		{
			System.out.println(Col.getText() + "\t");
		}
	}

}
