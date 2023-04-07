package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest31 {
	
	public static String username = "admin"; //Reading thing this from external XLS or CSV
	public static String password = "admin"; //Reading thing this from external XLS or CSV
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://"+username+":"+password +"@the-internet.herokuapp.com/basic_auth");
	}
}
