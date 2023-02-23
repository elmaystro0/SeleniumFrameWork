package data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonDataReader 
{
	public String FirstName, LastName, Email, Password;
	public void JsonReader() throws FileNotFoundException, IOException, ParseException
	{
		String FilePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcFile = new File(FilePath);
		JSONParser parser = new JSONParser();
		org.json.simple.JSONArray jarray = (org.json.simple.JSONArray) parser.parse(new FileReader(srcFile));
		
		for (Object Jsonobj : jarray) 
		{
			JSONObject person = (JSONObject) Jsonobj;
			FirstName = (String) person.get("FirstName");
			System.out.println(FirstName);
			LastName = (String) person.get("LastName");
			System.out.println(LastName);
			Email = (String) person.get("Email");
			System.out.println(Email);
			Password = (String) person.get("Password");
			System.out.println(Password);
		}
	}
}
