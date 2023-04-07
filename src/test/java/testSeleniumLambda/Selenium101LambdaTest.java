package testSeleniumLambda;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Selenium101LambdaTest {

//	public static WebDriver driver2;
	public String username = "janjira0024";
	public String accesskey = "4lRsqQ3rQjEGpAm5QPo3NUWJIhrIKIgVbjqZ2a5pbxs1bVL4go";
	public RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	
	@BeforeTest
	@Parameters(value={"browser","version","platform"})
	public void setUp(String browser, String version, String platform) {
		  DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	      capabilities.setCapability("build", "Selenium Grid");
	      capabilities.setCapability("name", "Sample Test");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      try {
	          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//		      ChromeOptions browserOptions = new ChromeOptions();
//		      browserOptions.addArguments("--remote-allow-origins=*");
//		      driver2 = new ChromeDriver(browserOptions);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
	          ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
	          driver.quit();
//	  	      driver2.close();
	    }
	}

	@Test
	public void testcase1() {	
//		if(brower.equals("Firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}else if(brower.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}else if(brower.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(true, url.contains("simple-form-demo"));
		String strText = "Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(strText);
		driver.findElement(By.xpath("//*[@id=\"showInput\"]")).click();
		String actualText = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(strText, actualText);
	}

	@Test
	@Parameters(value={"browser"})
	public void testcase2(String browser) {
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement greenSlider = driver.findElement(By.cssSelector("input[value='15']"));
		Actions builder = new Actions(driver);
		if(browser.equalsIgnoreCase("firefox")) {
			Action dragAndDrop = builder.clickAndHold(greenSlider).moveByOffset(116,0).release().build();
			dragAndDrop.perform();
		}
		else if(browser.equalsIgnoreCase("Opera")) {
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].value=80;", greenSlider);
			greenSlider.click();
			for(int i=0;i<44;i++) {
				greenSlider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		else {
			Action dragAndDrop = builder.clickAndHold(greenSlider).moveByOffset(120,0).release().build();
			dragAndDrop.perform();
		}
		String outputText = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
		Assert.assertEquals("95", outputText);
	}

	@Test
	@Parameters(value={"browser"})
	public void testcase3(String browser) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

		WebElement name = driver.findElement(By.name("name"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;", name);
		if (isRequired) {
			Assert.assertEquals(true, true);
			driver.findElement(By.id("name")).sendKeys("Jame");
			driver.findElement(By.id("inputEmail4")).sendKeys("Jame@gmail.com");
			driver.findElement(By.id("inputPassword4")).sendKeys("123456");
			driver.findElement(By.id("company")).sendKeys("Atos");
			driver.findElement(By.id("websitename")).sendKeys("www.jame.com");
			if(browser.equalsIgnoreCase("Opera")) {
				driver.findElement(By.xpath("//option[@value='US']")).click();
			}else {
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByValue("US");
			}
			driver.findElement(By.id("inputCity")).sendKeys("Bangkok");
			driver.findElement(By.id("inputAddress1")).sendKeys("Bangkok1");
			driver.findElement(By.id("inputAddress2")).sendKeys("Bangkok2");
			driver.findElement(By.id("inputState")).sendKeys("Bangkok3");
			driver.findElement(By.id("inputZip")).sendKeys("11000");
		}
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"exit_popup_close\"]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		String expectedStr = "Thanks for contacting us, we will get back to you shortly.";
		String actualStr = driver.findElement(By.cssSelector(".success-msg.hidden")).getText();
		Assert.assertEquals(expectedStr, actualStr);
	}
}
