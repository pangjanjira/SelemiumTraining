package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonDataSetup;

@Test(groups="user-registration")
public class GroupDemoTest extends CommonDataSetup {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Run this before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Run this after class");
	}
	
	@BeforeGroups(value="regression")
	public void beforeGroups() {
		System.out.println("Run this method before regression");
	}
	
	@AfterGroups(value="regression")
	public void afterGroups() {
		System.out.println("Run this method after regression");
	}


	@Test(priority=1,groups="regression")
	public void aTest1() {
		System.out.println("Test 1");
	}
	
	@Test(priority=2,groups="regression")
	public void aTest2() {
		System.out.println("Test 2");
		Assert.assertTrue(false);
	}
	
	@Test(groups= {"regression","regression2"})
	public void aTest3() {
		System.out.println("Test 3");
	}
	
	@Test(groups="regression2")
	public void aTest4() {
		System.out.println("Test 4");
	}
	
}
