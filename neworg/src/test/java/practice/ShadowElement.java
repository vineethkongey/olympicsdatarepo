package practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement {

	
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://books-pwakit.appspot.com/detail/dmx8DwAAQBAJ");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 WebElement element = (WebElement) js.executeScript("return document.querySelector('body > book-app').shadowRoot.querySelector('#input')");
		 element.sendKeys("Vineeth");
	}
}
