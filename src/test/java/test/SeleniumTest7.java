package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest7 {
	
	public static String brower = "chrome"; // External configuration - XLSX, CSV
	public static WebDriver driver;

	public static void main(String[] args) {
		
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
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("user-name")).clear();
		System.out.println(driver.findElement(By.name("user-name")).getAttribute("class"));
//		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getCssValue("text-transform"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getSize());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getTagName());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isSelected());

//		driver.close();
	}

}
