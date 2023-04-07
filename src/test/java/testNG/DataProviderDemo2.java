package testNG;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderDemo2 {
	
	@DataProvider(name="create")
	public Object[][] dataSet1(Method m) {
		
		Object[][] testdata = null;
		
		if(m.getName().equals("test")) {
			testdata = new Object[][] {
				{"username","password"},
				{"username1","password1"},
				{"username2","password2"},
				{"username3","password3"}
			};
		}else if(m.getName().equals("test1")){
			testdata = new Object[][] {
				{"username","password","test"},
				{"username1","password1","test1"},
				{"username2","password2","test2"},
				{"username3","password3","test3"}
			};
		}else if(m.getName().equals("test2")){
			testdata = new Object[][] {
				{"username","password","test","fourth"},
				{"username1","password1","test1","fourth"},
				{"username2","password2","test2","fourth"},
				{"username3","password3","test3","fourth"}
			};
		}
		return testdata;
	}

//	@DataProvider
//	public Object[][] dataSet() {
//		Object[][] dataset = new Object[4][2];
//
//		// first row
//		dataset[0][0] = "user1";
//		dataset[0][1] = "pass1";
//
//		// second row
//		dataset[1][0] = "user2";
//		dataset[1][1] = "pass2";
//
//		// third row
//		dataset[2][0] = "user3";
//		dataset[2][1] = "pass3";
//
//		// fourth row
//		dataset[3][0] = "user4";
//		dataset[3][1] = "pass4";
//		
//		return dataset;
//	}

}
