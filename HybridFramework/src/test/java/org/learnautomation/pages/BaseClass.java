package org.learnautomation.pages;

import java.io.IOException;

import org.learnautomation.factory.BrowserFactory;
import org.learnautomation.factory.ConfigDataProvider;
import org.learnautomation.factory.DataProviderFactory;
import org.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupTestSuite()
	{
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Freecrmlogin.html");
		report= new ExtentReports();
		report.attachReporter(html);
	}
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(DataProviderFactory.getConfig().geturl(), DataProviderFactory.getConfig().getbrowser());
	}
	@AfterClass
	public void teardown()
	{
		BrowserFactory.closeApplication(driver);
	}
	@AfterMethod
public void teandownTest(ITestResult result)
{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("test Passed");
			
					}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	report.flush();
}

}
