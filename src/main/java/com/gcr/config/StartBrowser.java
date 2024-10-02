package com.gcr.config;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
 public static WebDriver driver;
//set up report
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;

	@BeforeTest
	public void generateReport()
	{
		sparkReporter = new ExtentSparkReporter("Reports/MyAutomationreport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	@BeforeMethod
	public void methodName(Method method)
	{
		parentTest = extent.createTest(method.getName()); 
	}
  @BeforeClass
  public void beforeClass() {
	//  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterClass
  public void afterClass() {
	  extent.flush();
	  driver.quit();
  }

}
