package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// we must put the Java Script Executer inside the instructor method
		Jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement RegisterLink;
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;
	@FindBy(id = "customerCurrency")
	WebElement ChangeCurrencyList;
	@FindBy(linkText = "Computers")
	WebElement OpenComputerMenu;
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement ClickonNoteBooks;
	
	
	
	
	public void OpenRegisterationPage()
	{
		//RegisterLink.click();
		ClickButton(RegisterLink);
	}
	public void OpenLoginPage()
	{
		ClickButton(LoginLink);
	}
	public void OpenContactUsPage()
	{
		ScrollDownToBottom();
		ClickButton(ContactUsLink);
	}
	public void ChangeCurrency()
	{
		select = new Select(ChangeCurrencyList);
		select.selectByIndex(1);
	}
	public void SelectNoteBooksMenu()
	{
		action.moveToElement(OpenComputerMenu).moveToElement(ClickonNoteBooks).click().build().perform();
	}
	
}
