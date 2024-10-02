package com.gcr.or;

import org.openqa.selenium.By;

public class LoginPage {

	public static By txtUserName = By.id("user-name");
	public static By txtPassword = By.name("password");
	public static By btnLogin = By.xpath("//input[@value='Login']");
}
