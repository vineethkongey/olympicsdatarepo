package practice.seleniumScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelFileHandling {
	@Test
	public void excelfile() throws EncryptedDocumentException, IOException {
		FileInputStream fis  =new FileInputStream("./data/Read.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		for(int i=1;i<count;i++) {
		
			Row row = sh.getRow(i);
			String firstcolData=row.getCell(0).getStringCellValue();
			String secondcoldata = row.getCell(1).getStringCellValue();
			System.out.println(firstcolData+"\t"+secondcoldata);
			
		}
		
		
	}

}
