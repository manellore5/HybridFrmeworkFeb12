package org.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	
	public static String captureScreenshots(WebDriver driver)
	{
		String path = System.getProperty("user.dir")+"/ScreenShots/FreeCRM"+System.currentTimeMillis()+".png";
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}
	
	public static void  verifyTitle(WebDriver driver, String expectedTitle){
		boolean status=new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertTrue(status);
	}
	public static void  verifyUrl(WebDriver driver, String url){
		boolean geturl=new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(url));
		Assert.assertTrue(geturl);
	}
	public static WebElement waitforWebElement1(WebDriver driver,String Xpath, int time)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
				
	}
	public static WebElement waitforWebElement1(WebDriver driver,WebElement element, int time)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
				
	}
	public static WebElement waitforWebElement(WebDriver driver,By by, int time)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
		
	}
	public String getCurrentDateandTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		
		 Date date = new Date();
		 
		
		 String date1= dateFormat.format(date);
		 
	
		 return date1;
	}
	
	public void handleFrameusingId(WebDriver driver, String id)
	{
		 new WebDriverWait(driver,20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id)));
	}
	
	public void handleFrameUsingName(WebDriver driver, String name)
	{
		 new WebDriverWait(driver,20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(name)));

	}
	
	public void handleFrameusingElement(WebDriver driver, WebElement element)
	{
		new WebDriverWait(driver,20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void acceptAlert(WebDriver driver)
	{
		 new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		 new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	public String getTextfromAlert(WebDriver driver)
	{
		return new WebDriverWait(driver,20).until(ExpectedConditions.alertIsPresent()).getText();
		
	}
	
	public void switchWindows(WebDriver driver, String handle)
	{
		 
		driver.switchTo().window(handle);
	}
}
