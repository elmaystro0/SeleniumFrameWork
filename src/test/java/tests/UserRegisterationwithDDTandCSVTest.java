package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandCSVTest extends TestBase
{
	HomePage HomeObject;
	UserRegisterationPage RegisterObject;
	LoginPage LoginObject;
	CSVReader reader;
	@Test (priority = 1)
	public void UserCanRegisterSuccssfully () throws CsvValidationException, IOException
	{
		//get the CSV_file Path
		String CSV_File = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_File));

		String [] CSVcell;
		// Using While Loop To get the data of every Cell
		while ((CSVcell = reader.readNext()) != null) {
			String FirstName = CSVcell[0];
			String LastName = CSVcell[1];
			String Email = CSVcell[2];
			String Password = CSVcell[3];	
			HomeObject = new HomePage(driver);
			HomeObject.OpenRegisterationPage();
			RegisterObject = new UserRegisterationPage(driver);
			RegisterObject.UserRegisteration(FirstName, LastName, Email, Password);
			Assert.assertTrue(RegisterObject.Registerationdone.getText().contains("Your registration completed"));
		}
	}
	@Test (dependsOnMethods = "RegisteredUserCanLogin", enabled = false)
	public void RegisteredUserCanLogout()
	{
		RegisterObject.UserLogout();
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccssfully")
	public void RegisteredUserCanLogin() throws CsvValidationException, IOException
	{
		//get the CSV_file Path
		String CSV_File = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_File));

		String [] CSVcell;
		// Using While Loop To get the data of every Cell
		while ((CSVcell = reader.readNext()) != null) {
			String Email = CSVcell[2];
			String Password = CSVcell[3];	
			LoginObject = new LoginPage(driver);
			HomeObject.OpenLoginPage();
			LoginObject.UserLogin(Email, Password);
			Assert.assertTrue(RegisterObject.LogOutClick.getText().contains("Log out"));
			RegisterObject.UserLogout();
		}
	}
}