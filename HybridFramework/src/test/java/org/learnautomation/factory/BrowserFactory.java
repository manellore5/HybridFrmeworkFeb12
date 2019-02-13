package org.learnautomation.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {
	
	public static WebDriver startApplication(String url, String browserName)
	{
		 WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumMukesh\\chromedriver.exe");

			//ChromeOptions option = new ChromeOptions();
			//option.setAcceptInsecureCerts(true);
			//option.addArguments("--disable--notifications");
			driver= new ChromeDriver();
					}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--disable--notifications");
			System.setProperty("Webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");

		driver= new FirefoxDriver(option);
					}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			InternetExplorerOptions option = new InternetExplorerOptions();
			
			driver= new InternetExplorerDriver(option);
			
		}
		else
		{
			System.out.println("Please provide valid driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		return driver;
	}
	
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}

}
