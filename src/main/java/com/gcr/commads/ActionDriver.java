package com.gcr.commads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gcr.config.StartBrowser;

public class ActionDriver {
	
	public WebDriver driver;
	
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}

	/**
	 * This command is used to navigate to any URL
	 * @param url -- APplication URL
	 */
	public void navigateToApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Navigation Successful :"+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Navigation Unsuccessful :"+url);
		}
	}
	/**
	 * This command used to perform click on links, radio buttons, check boxes and buttons
	 * @param locator  -- Element definition, how you are identifying element
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully perfomred click action on : "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perfomre click action on: "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw new Exception();
		}
	}
	/**
	 * This command is used to perform type in text boxes and text area
	 * @param locator  -- Element definition, how you are identifying element
	 * @param testData  - what you want to type in text box
	 * @param eleName-- Name of the element
	 * @throws Exception
	 */
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully perfomred type action on : "+eleName + " with data :" +testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perfomre type action on: "+eleName + " with data :" +testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw new Exception();
		}
	}
	/**
	 * Wait for Visibility of element
	 * @param Sec -- max time to wait in seconds
	 * @param locator ---- Element definition, how you are identifying element
	 * @param eleName-- Name of the element
	 * @throws Exception
	 */
	public void explicitWaitForVisibilityOfElement(Duration Sec, By locator, String eleName) throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Sec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			StartBrowser.childTest.pass("Successfully waited for element and its visible: "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("waited for element but its timedout: "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw new Exception();
		}
	}
	/**
	 * Get text from element which is on webpage
	 * @param locator
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public String getTextFromPage(By locator, String eleName) throws Exception
	{   
		String text = null;
		try {
		 text =driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Successfully got text from element: "+eleName);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Get text: "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw new Exception();
		}
		return text;
	}
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}
