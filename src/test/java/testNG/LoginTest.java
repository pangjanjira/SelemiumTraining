package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonDataSetup;

public class LoginTest extends CommonDataSetup {
	
	@BeforeTest
	public void loginToApplication() {
		System.out.println("Login to application");
	}
	
	@AfterTest
	public void logoutToApplication() {
		System.out.println("Logout to application");
	}
	
	@BeforeMethod
	public void connectToDB() {
		System.out.println("DB Connect");
	}
	
	@AfterMethod
	public void disconnectToDB() {
		System.out.println("DB Disconnect");
	}
	
	@Test(priority=1,description="This is a login test")
	public void loginTest() {
		System.out.println("[Test 1] Login is successful");
	}
	
	@Test(priority=2,description="This is a logout test",groups="regression")
	public void logoutTest() {
		System.out.println("[Test 2] Logout is successful");
	}
	
}
