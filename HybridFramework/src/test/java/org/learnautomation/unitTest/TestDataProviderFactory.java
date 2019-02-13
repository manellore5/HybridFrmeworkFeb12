package org.learnautomation.unitTest;

import org.learnautomation.factory.ConfigDataProvider;
import org.learnautomation.factory.ExcelDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataProviderFactory {
	@Test
	public void testExcel()
	{
		ExcelDataProvider excel= new ExcelDataProvider();
		String data=excel.getStringData(1, 0, 0);
		Assert.assertEquals(data, "TestingExcel");
	}
	@Test
	public void testconfig()
	{
		ConfigDataProvider config= new ConfigDataProvider();
		//System.out.println(config.getValue(url));
		System.out.println(config.getValue("browser"));

	}
}
