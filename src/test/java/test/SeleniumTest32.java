package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SeleniumTest32 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("C:\\Users\\j\\eclipse-workspace\\SelemiumTraining\\src\\main\\resources\\properties\\testdata.properties");
		properties.load(inputstream);
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties.getProperty("url"));
		
		FileOutputStream outputstream = new FileOutputStream("C:\\Users\\j\\eclipse-workspace\\SelemiumTraining\\src\\main\\resources\\properties\\testdata.properties");
		properties.setProperty("testdata", "123456789");
		properties.store(outputstream, "Test data");
	}
}
