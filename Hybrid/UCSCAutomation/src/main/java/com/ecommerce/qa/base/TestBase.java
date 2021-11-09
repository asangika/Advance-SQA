package com.ecommerce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecommerce.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;

	public TestBase(){
		try{
			properties = new Properties();
			FileInputStream iprop = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
			+"ecommerce/qa/config/config.properties");
			properties.load(iprop);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		} 

	}

	public static void initialization(){
		String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C://Users//User//Downloads//Compressed//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("Firefox")){
			//System.out.println("Browser Firefox");
			//driver = new FirefoxDriver	
		}
		else if (browserName.equals("IE")){
			//code for IE Driver
		}
	
			
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(properties.getProperty("url"));
	
	}
}
