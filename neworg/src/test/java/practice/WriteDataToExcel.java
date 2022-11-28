package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataToExcel {
	@Test
	public void writeData() throws EncryptedDocumentException, FileNotFoundException, IOException  {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./exceldata/olympicsdata.xlsx"));
		Sheet sheet = wb.getSheet("atheletes");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/");
		WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		cookies.click();
		
	//	WebElement ele = driver.findElement(By.xpath("//div[@class='b2p-col__12']"));
		WebElement viewElement=driver.findElement(By.xpath("//h2[text()='Featured']/following-sibling::a/span[text()='View all']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", viewElement);
		By closeBtn=By.xpath("//button[@class='button-no-styles icon-close-button pvp-modal__close']");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtn));
		WebElement btn = driver.findElement(closeBtn);
		btn.click();
		List<WebElement> nameOfAtletics = driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']/span"));
		List<WebElement> nameOfGame=driver.findElements(By.xpath("//a[@class='featured-athlete__discipline text-body-sm']"));
		List<WebElement> country=driver.findElements(By.xpath("//span[@class='featured-athlete__country--label featured-athlete__country--name']"));
		List<WebElement> medals=driver.findElements(By.xpath("//div[@class='featured-athlete__medals text-body-sm']"));
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Map<String, String> map=null;
		
		for(int i=0;i<nameOfAtletics.size();i++) {
		map=new HashMap<String, String>();
		map.put("Person", nameOfAtletics.get(i).getText());
		map.put("Game", nameOfGame.get(i).getText());
		map.put("Country", country.get(i).getText());
		map.put("Medals", medals.get(i).getText().replaceAll("\n", ""));
		list.add(map);
//		sheet.createRow(i).createCell(0).setCellValue(nameOfAtletics.get(i).getText());
//		sheet.getRow(i).createCell(1).setCellValue(nameOfGame.get(i).getText());
//		sheet.getRow(i).createCell(2).setCellValue(country.get(i).getText());
//		sheet.getRow(i).createCell(3).setCellValue(medals.get(i).getText().replaceAll("\n", ""));
		}
		System.out.println(getMedalForPerson(list, "Eliud KIPCHOGE","Medals"));
		System.out.println(getMedalForPerson(list, "Eliud KIPCHOGE","Country"));
//		FileOutputStream fos = new FileOutputStream("./exceldata/olympicsdata.xlsx");	
//		wb.write(fos);
	}
	
	public static String getMedalForPerson(List<Map<String, String>> list, String personName, String reqComponent) {
		String value=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("Person").equals(personName)) {
				value=list.get(i).get(reqComponent);
				break;
			}
		}
		return value;
	}
}
