package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement MaleGenderBTN;
	
	@FindBy (id = "gender-female")
	WebElement FemaleGenderBTN;
	
	@FindBy (id = "FirstName")
	WebElement FirstNameBox;
	
	@FindBy(id = "LastName")
	WebElement LastNameBox;
	
	@FindBy (id = "Email")
	WebElement EmailIDBox;
	
	@FindBy(id = "Password")
	WebElement PasswordBox;
	
	@FindBy (id = "ConfirmPassword")
	WebElement ConfirmPasswordBox;
	
	@FindBy (id = "register-button")
	WebElement RegisterBTN;
	
	@FindBy (linkText = "Log out")
	public WebElement LogOutClick;
	
	@FindBy (css = "div.result")
	public WebElement Registerationdone;
	
	@FindBy(linkText = "My account")
	WebElement MyAccountLink;
	

	
	public void UserRegisteration(String FirstName, String LastName, String Email, String Password)
	{
		//MaleGenderBTN.click();
		ClickButton(MaleGenderBTN);
		//FirstNameBox.sendKeys(FirstName);
		ElementTextFill(FirstNameBox, FirstName);
		//LastNameBox.sendKeys(LastName);
		ElementTextFill(LastNameBox, LastName);
		//EmailIDBox.sendKeys(Email);
		ElementTextFill(EmailIDBox, Email);
		//PasswordBox.sendKeys(Password);
		ElementTextFill(PasswordBox, Password);
		//ConfirmPasswordBox.sendKeys(Password);
		ElementTextFill(ConfirmPasswordBox, Password);
		//RegisterBTN.click();
		ClickButton(RegisterBTN);
	}
	public void UserLogout()
	{
		ClickButton(LogOutClick);
	}
	public void OpenMyAccountPage()
	{
		ClickButton(MyAccountLink);
	}

}
