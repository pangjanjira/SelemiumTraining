package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest28 {
	
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
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		
		//Print the title of the page
		String script = "return document.title";
		String title = (String) jsexec.executeScript(script);
		System.out.println(title);
		
		//Click button
		driver.switchTo().frame("iframeResult");
		jsexec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		//Highlight button
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		jsexec.executeScript("arguments[0].style.border='5px solid green'", button);
		
		//Scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement learnmoreButton = driver.findElement(By.xpath("//*[@id=\"proFromDefault\"]"));
		jsexec.executeScript("arguments[0].scrollIntoView(true);",learnmoreButton);
		
	}
}
