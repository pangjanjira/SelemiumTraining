package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest13 {
	
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
		
		driver.get("https://www.dofactory.com/html/input/checkbox");
		driver.manage().window().maximize();
//		WebElement radio = driver.findElement(By.id("flexRadioDefault1"));
//		Actions action = new Actions(driver);
//		action.moveToElement(radio);
//		action.perform();
//		Thread.sleep(2000);
		driver.findElement(By.name("html")).click();
//		driver.findElement(By.xpath("//input[@id='vehicle1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("html")).click();
//		driver.findElement(By.xpath("//input[@id='vehicle1']")).click();
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

}
