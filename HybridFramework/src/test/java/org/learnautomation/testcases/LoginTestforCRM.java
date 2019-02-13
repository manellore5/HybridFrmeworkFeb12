package org.learnautomation.testcases;

import org.learnautomation.factory.BrowserFactory;
import org.learnautomation.factory.ConfigDataProvider;
import org.learnautomation.factory.DataProviderFactory;
import org.learnautomation.factory.ExcelDataProvider;
import org.learnautomation.pages.BaseClass;
import org.learnautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class LoginTestforCRM extends BaseClass {
	
	LoginPage loginobj;


	@Test
	public void loginCRM()
	{
		logger = report.createTest("LoginTestforCRM");
		loginobj=PageFactory.initElements(driver, LoginPage.class);
				loginobj.login1(DataProviderFactory.getExcel().getStringData("Login", 0, 0), DataProviderFactory.getExcel().getStringData("Login", 0, 1));
	logger.info("testing logger");
		logger.pass("test sucessfull");	
	}
	

}
