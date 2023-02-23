package helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	// Method to Take Screenshot on failure 
	public static void CaptureScreenShot(WebDriver driver, String ScreenShotName)
	{
		Path dest = Paths.get("./ScreenShots",ScreenShotName+".png" );
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception While taking ScreenShot" + e.getMessage());
			e.printStackTrace();
		}
	}

}
