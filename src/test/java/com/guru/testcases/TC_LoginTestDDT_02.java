package com.guru.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.pageObject.LoginPage;
import com.guru.utilities.XLUtils;

public class TC_LoginTestDDT_02 extends BaseClass {
	@Test(dataProvider="TestDataF")
	public void LoginDDT(String username,String password) {
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername(username);
		logger.info("username is provide");
		lp.enterPassword(password);
		logger.info("password is provided");
		lp.loginonButton();
		if(isAleretpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}else{
			Assert.assertTrue(true);
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login passed");
		}
		}
	
	public static boolean isAleretpresent() {
		try{
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
			
		}
		

	}
	
	
	
	
	
	@DataProvider(name="TestDataF")
	String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/guru/testData/TestDataF.xlsx";
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]= new String[rowcount][colcount];
		 for(int i=1;i<=rowcount;i++){
			 for(int j=1;j<colcount;j++) {
				 logindata[i-1][j]=XLUtils.getcellData(path, "Sheet1", i, j);
				 
			 }
			 
		 }
		return logindata;
		
	}

}
