package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"Browser"})
	public void StartDriver (@Optional ("Chrome") String BrowserName)
	{
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}		
		else if (BrowserName.equalsIgnoreCase("Iexplorer")) {
			driver = new InternetExplorerDriver();
		}
		else if (BrowserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void StopDriver()
	{
		driver.quit();
	}
	// Take ScreenShot when Test Case Fail and add it to ScreenShot Folder
	@AfterMethod
	public void ScreenShotonFailure(ITestResult Result)
	{
		if (Result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot ...");
			Helper.CaptureScreenShot(driver, Result.getName());
		}
	}
	
}
