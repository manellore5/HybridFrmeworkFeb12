package org.learnautomation.unitTest;

import org.learnautomation.factory.BrowserFactory;
import org.learnautomation.factory.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrowserFactory {
	@Test
	public void testBrowser()
	{
		WebDriver driver= BrowserFactory.startApplication(DataProviderFactory.getConfig().geturl(), DataProviderFactory.getConfig().getbrowser());
		Assert.assertTrue(!(driver==null));
		System.out.println(driver);
	}

}
