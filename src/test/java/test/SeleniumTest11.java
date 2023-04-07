package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest11 {
	
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
		
		driver.get("https://www.salesforce.com/th/form/signup/freetrial-sales/?d=70130000000EqoP");
		driver.manage().window().maximize();
		
		List<WebElement> allTags = driver.findElements(By.tagName("option"));	
		System.out.println("Total of link : " +allTags.size());
		
		for(int i=0;i<allTags.size();i++) {
			System.out.println("Link on page are : " +allTags.get(i).getAttribute("value"));
			System.out.println("Link on page are : " +allTags.get(i).getText());
		}
	}

}
