package practice.seleniumScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopUP {
	@Test
	public void allowPopup() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.easemytrip.com/");
	
		
		
		
		
		
		
		
	}

}
