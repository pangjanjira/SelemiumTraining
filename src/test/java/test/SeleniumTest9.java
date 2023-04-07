package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest9 {
	
	public static String brower = "chrome"; // External configuration - XLSX, CSV
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		if(brower.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(brower.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(brower.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.id("multi-select-demo"));	
		Select select = new Select(dropDown);
		select.selectByValue("jQuery");
		Thread.sleep(2000);
		select.selectByIndex(3);
		Thread.sleep(2000);
		List<WebElement> allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		Thread.sleep(2000);
		select.deselectAll();
		Thread.sleep(2000);
		select.selectByValue("jQuery");
		Thread.sleep(2000);
		select.selectByIndex(3);
		Thread.sleep(2000);
		select.deselectByIndex(3);
		Thread.sleep(2000);
		List<WebElement> allItems1 = select.getAllSelectedOptions();
		System.out.println(allItems1.size());
		
	}

}
