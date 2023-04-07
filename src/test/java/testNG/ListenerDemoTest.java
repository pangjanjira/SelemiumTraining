package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

public class ListenerDemoTest extends BaseTest{
	
//	@Test(retryAnalyzer = common.Retry.class)
	@Test
	public void launchApp() {
		driver.get("https://www.ebay.com/");
		Assert.assertTrue(false);
	}

}
