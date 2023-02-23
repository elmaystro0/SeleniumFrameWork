package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement FullName;
	@FindBy(id = "Email")
	WebElement Email;
	@FindBy(id = "Enquiry")
	WebElement Enquiry;
	@FindBy (css = "button.button-1.contact-us-button")
	WebElement SubmitBTN;
	@FindBy(css = "div.result")
	public WebElement Result;
	public void ContactUs(String FullNametxt, String Emailtxt, String Messagetxt)
	{
		ElementTextFill(FullName, FullNametxt);
		ElementTextFill(Email, Emailtxt);
		ElementTextFill(Enquiry, Messagetxt);
		ClickButton(SubmitBTN);
	}
	
}
