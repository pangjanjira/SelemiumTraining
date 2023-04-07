package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest1 {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j\\Documents\\lib_jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

}
