package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHooverMenuTest  extends TestBase {
	HomePage HomeObject;
	
	@Test
	public void UserCanopenNoteBooksMenu()
	{
		HomeObject = new HomePage(driver);
		HomeObject.SelectNoteBooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}

}
