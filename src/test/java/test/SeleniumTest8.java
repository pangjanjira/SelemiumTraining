package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest8 {
	
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
		
		driver.get("https://getbootstrap.com/docs/4.1/components/input-group/#custom-select");
		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.id("inputGroupSelect03"));
		Select select = new Select(dropDown);
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText());
		select.selectByValue("1");
		Thread.sleep(2000);
		select.selectByVisibleText("Two");
		Thread.sleep(2000);
		select.selectByIndex(3);
		Thread.sleep(2000);
//		driver.close();
	}

}
