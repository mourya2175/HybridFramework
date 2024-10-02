package com.gcr.reuse;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.gcr.commads.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.or.HomePage;
import com.gcr.or.LoginPage;

public class Commonfunctions {

	public WebDriver driver;
	public ActionDriver aDriver;
	
	public Commonfunctions()
	{
		driver = StartBrowser.driver;
		aDriver = new ActionDriver();
	}
	
	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to SauceDemo application");
		aDriver.navigateToApplication("https://www.saucedemo.com/");
		aDriver.type(LoginPage.txtUserName, "standard_user", "userName textbox");
		aDriver.type(LoginPage.txtPassword, "secret_sauce", "Password textbox");
		aDriver.click(LoginPage.btnLogin, "Login button");
	}
	
	public void login(String userName, String Password) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to SauceDemo application excel");
		aDriver.navigateToApplication("https://www.saucedemo.com/");
		aDriver.type(LoginPage.txtUserName, userName, "userName textbox");
		aDriver.type(LoginPage.txtPassword, Password, "Password textbox");
		aDriver.click(LoginPage.btnLogin, "Login button");
	}
	
	public void logout() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from SauceDemo application");
		aDriver.click(HomePage.btnMenu, "Home Page Menu");
		aDriver.click(HomePage.lnkLogout, "Logout link");
	}
	public void assertText(String expText) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Assert Text : "+expText);
		try {
			Assert.assertEquals(aDriver.getTextFromPage(HomePage.textProduct, "Product Message"), expText);
		} catch (AssertionError e) {
			StartBrowser.childTest.fail("Assertion is failed");
			throw e;
		}
	}
}
