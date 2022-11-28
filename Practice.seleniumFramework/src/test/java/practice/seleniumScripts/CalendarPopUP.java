package practice.seleniumScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUP {
	@Test
	public void Date() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		String datexpath=
					"//td[text()='Nov 2022']/ancestor::table[@class='rb-monthTable first last']/descendant::td[contains(@class,'day')]";
		String weekxpath="//td[text()='Nov 2022']/ancestor::table[@class='rb-monthTable first last']/descendant::td[@class='we day']";
		List<WebElement> dates = driver.findElements(By.xpath(datexpath));
		//System.out.println(dates);
		int count = driver.findElements(By.xpath(datexpath)).size();
		for(int i=0;i<count;i++) {
			String text=driver.findElements(By.xpath(datexpath)).get(i).getText();
			String text2=driver.findElements(By.xpath(weekxpath)).get(i).getText();
			if(text.equalsIgnoreCase(text2))
			{
			driver.findElements(By.xpath(weekxpath)).get(i).click();
			break;
			}
			}
			}

	}


