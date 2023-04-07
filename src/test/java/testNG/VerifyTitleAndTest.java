package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleAndTest {

	@Test
	public void titleTest() {	
		SoftAssert softassert = new SoftAssert();
		String expectedTitle ="Electronics, 11Cars, Fashion, Collectibles & More | eBay";
		String expectedText = "Search";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String actualTitle = driver.getTitle();
		System.out.println("Verification Title");
		softassert.assertEquals(actualTitle, expectedTitle);
		String actualText = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
		System.out.println("Verification Text");
		softassert.assertEquals(actualText, expectedText, "Text verification failed");
		driver.close();
		System.out.println("Close Browser");
		softassert.assertAll();
	}
}
