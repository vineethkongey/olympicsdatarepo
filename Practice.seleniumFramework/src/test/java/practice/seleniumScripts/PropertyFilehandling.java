package practice.seleniumScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFilehandling {
	@Test
	public void propertyfile() throws IOException {
		FileInputStream fis  = new FileInputStream("./data/propertiesfile.properties");
		Properties p = new Properties();
		p.load(fis);
		String browsername = p.getProperty("browser");
		String urlname = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get(urlname);;
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		
	}

	

}
