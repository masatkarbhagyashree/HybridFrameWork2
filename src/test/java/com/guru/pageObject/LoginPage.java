 package com.guru.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	 public LoginPage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
    } 
	@FindBy(name="uid")
	static WebElement txtusername;
	
	@FindBy(name="password")
	 static WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@name=\"btnLogin\"]")
	static WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	static WebElement lnklogout;
	
	public static void enterUsername(String txtToEnter) {
		txtusername.sendKeys(txtToEnter);
	}
	
	public static void enterPassword(String passwordToEnter) {
		password.sendKeys(passwordToEnter);
	}
	public static void loginonButton() {
		login.click();;
	}
	public static void logout() {
		lnklogout.click();

	}

}
