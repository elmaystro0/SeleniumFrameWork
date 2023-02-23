package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement EmailIDLoginTXT;
	
	@FindBy(id = "Password")
	WebElement PasswordLoginTXT;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement LoginBTN;
	
	public void UserLogin(String Email, String Password)
	{
		ElementTextFill(EmailIDLoginTXT, Email);
		ElementTextFill(PasswordLoginTXT, Password);
		ClickButton(LoginBTN);
	}

}
