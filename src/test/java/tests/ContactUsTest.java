package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
	HomePage HomeObject;
	ContactUsPage ContactObject;
	String FullNameTXT = "Mohamed Salama";
	String EmailTXT = "test@test.com";
	String MessageTXT = "Good Morning Team";
	@Test
	public void UserCanContactUse()
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenContactUsPage();
		ContactObject = new ContactUsPage(driver);
		ContactObject.ContactUs(FullNameTXT, EmailTXT, MessageTXT);
		Assert.assertTrue(ContactObject.Result.getText().contains("store owner"));
	}
}
