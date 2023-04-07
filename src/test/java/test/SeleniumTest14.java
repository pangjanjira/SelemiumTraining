package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest14 {
	
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
		
		driver.get("https://www.singaporeair.com/en_UK/th/home#/book/bookflight");
		driver.manage().window().maximize();
		WebElement radio1 = driver.findElement(By.id("bookFlights"));
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
//		radio1.click();
		System.out.println(radio1.isSelected());
		radio2.click();
		System.out.println(radio2.isSelected());
		System.out.println(driver.findElements(By.xpath("//*[@name='book-flight-radio']")).size());
		
//		driver.findElement(By.name("html")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("html")).click();
//		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

}
