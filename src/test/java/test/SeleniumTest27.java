package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest27 {
	
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
		
		//Step 1 : Switch to frame which has that particular
		//Step 2 : Get the number of rows
		//Step 3 : Get the number of columns
		//Step 4 : Iterate rows and columns and get text and print it
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
//		WebElement frame = driver.findElement(By.xpath("//*[@id=\"multi-column-0\"]/div/div/div/div/div/iframe"));
//		driver.switchTo().frame(frame);
		
		List<WebElement> rowElements = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
		System.out.println(rowElements.size());
		int rowSize = rowElements.size();
		
		List<WebElement> colElements = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td"));
		System.out.println(colElements.size());
		int colSize = colElements.size();
			
		for(int i=2;i<=rowSize;i++) {
			for(int j=1;j<=colSize;j++) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td["+j+"]")).getText() +"  ");
			}
			System.out.println();
		}
		
	}
}
