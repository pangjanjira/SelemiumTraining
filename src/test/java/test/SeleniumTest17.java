package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest17 {
	
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
		
		driver.get("https://www.salesforce.com/th/");
//		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[6]/div[1]/div[2]/div[2]/div/div[1]/div/a")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		System.out.println(parentWindow);
		String childtWindow = iterator.next();
		System.out.println(childtWindow);
		
		driver.switchTo().window(childtWindow);
		driver.findElement(By.name("UserFirstName")).sendKeys("Test1");
		Thread.sleep(2000);
		driver.findElement(By.name("UserLastName")).sendKeys("Test2");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
	}

}
