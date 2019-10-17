package com.guru.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import com.guru.pageObject.LoginPage;

public class TC_LoginTest_01 extends BaseClass {
	@Test
	public void m1() {
		driver.get(baseUrl);
	   logger.info("URL is opening");
		LoginPage l=new LoginPage(driver);
		l.enterUsername(username);
		 logger.info("Enter username");
		l.enterPassword(password);
		 logger.info("Enter password");
		l.loginonButton();
		
	}
	
}
  