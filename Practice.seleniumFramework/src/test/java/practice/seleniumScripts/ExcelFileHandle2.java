package practice.seleniumScripts;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileHandle2 {
	@Test
	public void excelfile() throws IOException {
		
		  XSSFWorkbook workbook=new XSSFWorkbook();
	         XSSFSheet sheet=workbook.createSheet("sheet1");
	              
	            // Creating HashMap and entering data
	            HashMap<String,String> map=new HashMap<String,String>();
	            map.put("1", "John");
	            map.put("2", "Joey");
	            map.put("3", "Ross");
	            map.put("4", "Rachel");
	              
	            int rowno=0;
	              
	            for(HashMap.Entry entry:map.entrySet()) {
	                XSSFRow row=sheet.createRow(rowno++);
	                row.createCell(0).setCellValue((String)entry.getKey());
	                row.createCell(1).setCellValue((String)entry.getValue());
	            }
	       
	            FileOutputStream file = new FileOutputStream("C:\\Users\\infot\\OneDrive\\Desktop\\handlng files\\Read.xlsx");
	            workbook.write(file);
	            file.close();
	            System.out.println("Data Copied to Excel");
	         

	}

}

	
	
