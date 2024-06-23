package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String getTestData(String sheetName, int row, int column ) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Software Testing Arise\\Automation Projects\\Naaptol\\src\\test\\resources\\TestData.xlsx");
		return WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}

}
