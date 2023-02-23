package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis = null;
	public FileInputStream getfileinptInputStream()
	{
		String FilePath = System.getProperty("user.dir"+ "\\src\\test\\java\\data\\UserData.xlsx");
		File srcfile = new File(FilePath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured: "+ e.getMessage());
			System.exit(0);
		}
		return fis;
	}
	public Object [][] getExcelData() throws IOException
	{
		fis = getfileinptInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberofColumns = 4;
		String [][] ArrayExcelData = new String [TotalNumberOfRows][TotalNumberofColumns];
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberofColumns; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				ArrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return ArrayExcelData;
	}
}
