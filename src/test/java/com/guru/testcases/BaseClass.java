package com.guru.testcases;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.guru.utilities.ReadConfig;
public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		logger=Logger.getLogger("HybridFramework");
		 PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		  driver = new ChromeDriver();
		
		  
		 
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}

}
