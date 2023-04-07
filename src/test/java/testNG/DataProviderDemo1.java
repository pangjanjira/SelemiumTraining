package testNG;

import org.testng.annotations.Test;

public class DataProviderDemo1 {
	
	@Test(dataProvider="create",dataProviderClass=DataProviderDemo2.class)
	public void test(String username,String password) {
		System.out.println(username+"====="+password);
	}
	
//	@Test(dataProvider="dataSet1")
	@Test(dataProvider="create",dataProviderClass=DataProviderDemo2.class)
	public void test1(String username,String password, String test) {
		System.out.println(username+"====="+password+"====="+test);
	}
	
	@Test(dataProvider="create",dataProviderClass=DataProviderDemo2.class)
	public void test2(String username,String password, String test, String test2) {
		System.out.println(username+"====="+password+"====="+test+"====="+test2);
	}

}
