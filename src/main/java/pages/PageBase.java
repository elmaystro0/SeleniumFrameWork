package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
	// hna momken n3ml ay 7aga shared ben kol l pages 
public class PageBase {
	
	//Create Driver that will handle all the test cases
	protected WebDriver driver;
	// Create JavaScript Executer for scroll down
	public JavascriptExecutor Jse;
	public Select select;
	public Actions action;
	//Create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// hna bn3ml element esmo click bdm ma m=nst5dm .click() kol shwya 
	protected static void ClickButton(WebElement Button)
	{
		Button.click();
	}
	// nfs l concept bs 3la send keys
	protected static void ElementTextFill (WebElement FieldName, String value )
	{
		FieldName.sendKeys(value);
	}
	// Create scroll using (0,2500) to scroll the bottom of page 
	public void ScrollDownToBottom()
	{
		Jse.executeScript("scrollBy(0,2500)");
	}
	// Create Clear Function
	public void ClearText(WebElement FieldName)
	{
		FieldName.clear();
	}

}
