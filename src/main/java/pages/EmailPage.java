package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	// Find the Needed fields and buttons
	
	@FindBy(id = "FriendEmail")
	WebElement FriendEmail;
	
	@FindBy(id = "PersonalMessage")
	WebElement Message;
	
	@FindBy(name = "send-email")
	WebElement SendBTN;
	
	@FindBy(css = "div.result")
	public WebElement Result;
	public void SendEmail(String FriendEmailTXT, String MessageTXT)
	{
		ElementTextFill(FriendEmail, FriendEmailTXT);
		ElementTextFill(Message, MessageTXT);
		ClickButton(SendBTN);
	}

}
