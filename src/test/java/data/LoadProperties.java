package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties
{ // Load the Properties File from the folder
	public static Properties UserData = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\UserData.Properties");
	
	private static Properties loadProperties (String path)
	{
		Properties pro = new Properties();
		try {
			FileInputStream Stream = new FileInputStream(path);
			pro.load(Stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error Occured: "+e.getMessage());
		}  catch (NullPointerException e) {
			System.out.println("Error Occured: "+e.getMessage());
		}
		return pro;
		
	}

}
