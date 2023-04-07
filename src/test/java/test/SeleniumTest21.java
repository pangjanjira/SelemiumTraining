package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest21 {
	
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
		
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		WebElement greenSide = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));		
		Actions action = new Actions(driver);
		action.dragAndDropBy(greenSide, 50, 120).perform();
		action.dragAndDropBy(greenSide, -50, 120).perform();
		
	}
}
