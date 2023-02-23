package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (linkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordField;
	@FindBy(id = "NewPassword")
	WebElement NewPassword;
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPassword;
	@FindBy(css = "button.button-1.change-password-button")
	WebElement ChangePasswordBTN;
	@FindBy(css = "div.bar-notification.success")
	public WebElement PasswordChangedSuccesfully;
	@FindBy(linkText = "Log out")
	WebElement LogoutBTN;
	@FindBy(css = "span.close")
	WebElement CloseNotification;
	
	public void OpenChangePasswordPage()
	{
		ClickButton(ChangePasswordLink);
	}
	public void ChangePassword(String OldPasswordTXT, String NewPasswordTXT)
	{
		ElementTextFill(OldPasswordField, OldPasswordTXT);
		ElementTextFill(NewPassword, NewPasswordTXT);
		ElementTextFill(confirmNewPassword, NewPasswordTXT);
		ClickButton(ChangePasswordBTN);
	}
	public void CloseNotification()
	{
		ClickButton(CloseNotification);
	}
	public void Logout ()
	{
		ClickButton(LogoutBTN);
	}
	
	

}
